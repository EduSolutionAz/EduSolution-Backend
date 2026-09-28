package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.country.*;
import com.edu.edusolution.dto.response.country.*;
import com.edu.edusolution.dto.response.university.CountryEntityResponseDTO;
import com.edu.edusolution.entity.country.CountryEntity;
import com.edu.edusolution.entity.country.CountrySectionEntity;
import com.edu.edusolution.entity.university.UniversityEntity;
import com.edu.edusolution.exception.*;
import com.edu.edusolution.repository.CountryRepository;
import com.edu.edusolution.repository.CountrySectionRepository;
import com.edu.edusolution.repository.UniversityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import static com.edu.edusolution.constants.S3Constants.*;
import static com.edu.edusolution.constants.ExceptionConstants.*;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountrySectionRepository countrySectionRepository;
    private final UniversityRepository universityRepository;
    private final S3Client s3Client;

    // For specific information about the country
    public CountrySectionResponseDTO getCountryInformation(CountrySectionRequestDTO request) {
        CountryEntity country = countryRepository.findByCountryNameIgnoreCase(request.getCountryName())
                .orElseThrow
                        (
                                CountryNotFoundException::new
                        );

        CountrySectionEntity section = countrySectionRepository.findByCountry(country)
                .orElseThrow
                        (
                                CountryNotFoundException::new
                        );

        List<String> universities = universityRepository.findAllByCountry(country).stream()
                .map(UniversityEntity::getUniversityName)
                .toList();


        return CountrySectionResponseDTO
                .builder()
                .title(country.getCountryName())
                .photoUrl(country.getCountryPhotoUrl())
                .title(section.getTitle())
                .content(section.getContent())
                .universities(universities)
                .areas(section.getAreas())
                .build();
    }

    // For Specific Details shown in main
    public List<TopCountriesInfoResponse> getTopCountriesInformation() {
        List<CountryEntity> countries = countryRepository.findTop6ByTopList(true);

        return countries.stream()
                .map(countryEntity -> TopCountriesInfoResponse
                        .builder()
                        .countryName(countryEntity.getCountryName())
                        .countryBGUrl(countryEntity.getCountryPhotoUrl())
                        .dormitoryHelp(countryEntity.getDormitoryHelp())
                        .universityCount(countryEntity.getUniversityCount())
                        .visaHelp(countryEntity.getVisaHelp())
                        .build()
                )
                .toList();
    }

    // For Country Flags shown in Main
    public List<CountryFlagResponseDTO> getCountryTopFlags() {
        List<CountryEntity> countryEntities = countryRepository.findTop10ByTopList(true);

        return countryEntities
                .stream()
                .map(
                        countryEntity ->
                                CountryFlagResponseDTO.builder()
                                        .countryFlagUrl(countryEntity.getCountryFlagUrl())
                                        .build()
                )
                .toList();

    }

    @Transactional
    public CountryAddResponseDTO addNewCountry(CountryAddRequestDTO request) {
        Optional<CountryEntity> checkCountry = countryRepository.findByCountryNameIgnoreCase(request.getCountryName());

        if (checkCountry.isPresent()) {
            throw new CountryAlreadyExists();
        }

        PutObjectRequest flagRequest = PutObjectRequest
                .builder()
                .bucket(S3_BUCKET_NAME)
                .key(COUNTRY_FOLDER_KEY + request.getCountryName().toLowerCase() + COUNTRY_FLAG_KEY)
                .contentType(request.getFlagImage().getContentType())
                .build();

        PutObjectRequest photoRequest = PutObjectRequest
                .builder()
                .bucket(S3_BUCKET_NAME)
                .key(COUNTRY_VIEW_FOLDER_KEY + request.getCountryName().toLowerCase() + COUNTRY_VIEW_KEY)
                .contentType(request.getCountryImage().getContentType())
                .build();

        try {
            s3Client.putObject(
                    flagRequest,
                    RequestBody.fromInputStream(
                            request.getFlagImage().getInputStream(),
                            request.getFlagImage().getSize()
                    )
            );

            s3Client.putObject(
                    photoRequest,
                    RequestBody.fromInputStream(
                            request.getCountryImage().getInputStream(),
                            request.getFlagImage().getSize()
                    )
            );
        } catch (IOException exception) {
            throw new CountryUploadException();
        }

        CountryEntity country = getCountryEntity(request);

        try {
            countryRepository.save(country);
        } catch (DataIntegrityViolationException ex) {
            throw new DataInsertException(DATA_INSERT_COUNTRY_MSG);
        }


        CountrySectionEntity section = getSectionEntity(request, country);

        try {
            countrySectionRepository.save(section);
        } catch (DataIntegrityViolationException ex) {
            throw new DataInsertException(DATA_INSERT_COUNTRY_SECTION_MSG);
        }


        return CountryAddResponseDTO
                .builder()
                .isCountryAdded(true)
                .countryName(request.getCountryName())
                .build();
    }

    @Transactional
    public DeleteCountryResponseDTO deleteCountry(DeleteCountryRequestDTO request) {
        CountryEntity country = countryRepository.findByCountryNameIgnoreCase(request.getCountryName())
                .orElseThrow(CountryNotFoundException::new);

        CountrySectionEntity section = countrySectionRepository.findByCountry(country)
                .orElseThrow(CountryNotFoundException::new);

        countrySectionRepository.delete(section);
        countryRepository.flush();
        countryRepository.delete(country);

        DeleteObjectRequest deleteObjectRequest =
                DeleteObjectRequest
                        .builder()
                        .bucket(S3_BUCKET_NAME)
                        .key(COUNTRY_FOLDER_KEY + request.getCountryName().toLowerCase() + COUNTRY_FLAG_KEY)
                        .build();

        DeleteObjectRequest deleteObjectRequest1 =
                DeleteObjectRequest
                        .builder()
                        .bucket(S3_BUCKET_NAME)
                        .key(COUNTRY_VIEW_FOLDER_KEY + request.getCountryName().toLowerCase() + COUNTRY_VIEW_KEY)
                        .build();


        try {
            s3Client.deleteObject(deleteObjectRequest);
            s3Client.deleteObject(deleteObjectRequest1);
        } catch (S3Exception ex) {
            throw new DataDeleteException(DATA_DELETE_S3_COUNTRY_MSG);
        }

        return DeleteCountryResponseDTO
                .builder()
                .isDeleted(true)
                .countryName(request.getCountryName())
                .build();
    }

    public UpdateCountryResponseDTO updateCountry(UpdateCountryRequestDTO request) {
        CountryEntity country = countryRepository.findByCountryNameIgnoreCase(request.getCountryName())
                .orElseThrow(CountryNotFoundException::new);

        country.setIcon(request.getIcon());
        country.setTopList(request.getIsTopList());
        country.setUniversityCount(request.getUniversityCount());
        country.setTuitionFeeEntry(request.getTuitionFee());
        country.setRentalFeeEntry(request.getRentalFee());
        country.setVisaHelp(request.getIsVisaHelp());
        country.setDormitoryHelp(request.getIsDormitoryHelp());

        countryRepository.save(country);

        CountrySectionEntity countrySection = countrySectionRepository.findByCountry(country)
                .orElseThrow(CountryNotFoundException::new);

        countrySection.setContent(request.getContent());
        countrySection.setAreas(request.getArea());

        countrySectionRepository.save(countrySection);

        return UpdateCountryResponseDTO
                .builder()
                .countryName(request.getCountryName())
                .isCountryAdded(true)
                .build();
    }

    public CountryEntityResponseDTO countryEntity(CountryEntityRequestDTO request) {
        CountryEntity country = countryRepository.findByCountryNameIgnoreCase(request.getCountryName())
                .orElseThrow(CountryNotFoundException::new);

        CountrySectionEntity countrySection = countrySectionRepository.findByCountry(country)
                .orElseThrow(CountryNotFoundException::new);



        return CountryEntityResponseDTO
                .builder()
                .countryName(country.getCountryName())
                .flagImage(country.getCountryFlagUrl())
                .countryImage(country.getCountryPhotoUrl())
                .universityCount(country.getUniversityCount())
                .tuitionFee(country.getTuitionFeeEntry())
                .rentalFee(country.getRentalFeeEntry())
                .icon(country.getIcon())
                .isVisaHelp(country.getVisaHelp())
                .isDormitoryHelp(country.getDormitoryHelp())
                .isTopList(country.getTopList())
                .content(countrySection.getContent())
                .area(countrySection.getAreas())
                .build();
    }


    private CountryEntity getCountryEntity(CountryAddRequestDTO request) {
        CountryEntity country = new CountryEntity();
        country.setCountryName(request.getCountryName());
        country.setCountryFlagUrl(S3_PUBLIC_SHARE_LINK + COUNTRY_FOLDER_KEY + request.getCountryName().toLowerCase() + COUNTRY_FLAG_KEY);
        country.setCountryPhotoUrl(S3_PUBLIC_SHARE_LINK + COUNTRY_VIEW_FOLDER_KEY + request.getCountryName().toLowerCase() + COUNTRY_VIEW_KEY);
        country.setDormitoryHelp(request.getIsDormitoryHelp());
        country.setRentalFeeEntry(request.getRentalFee());
        country.setTuitionFeeEntry(request.getTuitionFee());
        country.setVisaHelp(request.getIsVisaHelp());
        country.setTopList(request.getIsTopList());
        country.setUniversityCount(request.getUniversityCount());
        country.setIcon(request.getIcon());
        return country;
    }

    private CountrySectionEntity getSectionEntity(CountryAddRequestDTO request, CountryEntity country) {
        CountrySectionEntity section = new CountrySectionEntity();
        section.setCountry(country);
        section.setAreas(request.getArea());
        section.setTitle(request.getCountryName());
        section.setAreas(request.getArea());
        section.setContent(request.getContent());

        return section;
    }
}
