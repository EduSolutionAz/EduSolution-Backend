package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.university.AddUniversityRequestDTO;
import com.edu.edusolution.dto.request.university.DeleteUniversityRequestDTO;
import com.edu.edusolution.dto.request.university.UniversitySectionRequestDTO;
import com.edu.edusolution.dto.response.university.AddUniversityResponseDTO;
import com.edu.edusolution.dto.response.university.DeleteUniversityResponseDTO;
import com.edu.edusolution.dto.response.university.UniversityLogoResponseDTO;
import com.edu.edusolution.dto.response.university.UniversitySectionResponseDTO;
import com.edu.edusolution.entity.country.CountryEntity;
import com.edu.edusolution.entity.university.FacultyEntity;
import com.edu.edusolution.entity.university.UniversityEntity;
import com.edu.edusolution.entity.university.UniversitySectionEntity;
import com.edu.edusolution.exception.*;
import com.edu.edusolution.repository.CountryRepository;
import com.edu.edusolution.repository.FacultyRepository;
import com.edu.edusolution.repository.UniversityRepository;
import com.edu.edusolution.repository.UniversitySectionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.edu.edusolution.constants.S3Constants.*;
import static com.edu.edusolution.constants.ExceptionConstants.DATA_DELETE_S3_UNIVERSITY_MSG;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversitySectionRepository universitySectionRepository;
    private final FacultyRepository facultyRepository;
    private final S3Client s3Client;
    private final CountryRepository countryRepository;

    public List<UniversityLogoResponseDTO> getUniversityLogos(){
        List<UniversityEntity> universityEntities = universityRepository.findTop10ByIsPartner(true);

        return universityEntities
                .stream()
                .map(
                        universityEntity ->
                                UniversityLogoResponseDTO
                                        .builder()
                                        .universityLogoUrl(universityEntity.getUniversityLogoUrl())
                                        .build()
                )
                .toList();
    }

    public UniversitySectionResponseDTO getUniversityInformation(String universityName) {
        UniversityEntity checkUni = universityRepository.findByUniversityNameIgnoreCase(universityName)
                .orElseThrow(UniversityNotFoundException::new);

        UniversitySectionEntity checkSection = universitySectionRepository.findByUniversityEntity(checkUni)
                .orElseThrow(UniversityNotFoundException::new);

        List<FacultyEntity> faculties = facultyRepository.findAllByUniversity(checkUni);
        List<String> facultiesString = faculties.stream().map(FacultyEntity::getFacultyName).toList();

        return UniversitySectionResponseDTO.builder()
                .title(universityName)
                .content(checkSection.getContent())
                .photoUrl(checkUni.getUniversityLogoUrl())
                .viewUrl(checkUni.getUniversityViewUrl())
                .faculties(facultiesString)
                .build();
    }

    @Transactional
    public AddUniversityResponseDTO addUniversity(AddUniversityRequestDTO request) {
        Optional<UniversityEntity> checkUni = universityRepository.findByUniversityNameIgnoreCase(request.getUniversityName());

        if (checkUni.isPresent()){
            throw new UniversityAlreadyExistsException();
        }

        CountryEntity country = countryRepository.findByCountryNameIgnoreCase(request.getCountryName())
                .orElseThrow(CountryNotFoundException::new);

        PutObjectRequest flagRequest = PutObjectRequest
                .builder()
                .bucket(S3_BUCKET_NAME)
                .key(UNIVERSITY_FOLDER_KEY+request.getUniversityName().toLowerCase().replace(' ','_')+UNIVERSITY_LOGO_KEY)
                .contentType(request.getUniversityLogo().getContentType())
                .build();
        // university-view-bucket

        PutObjectRequest viewRequest = PutObjectRequest
                .builder()
                .bucket(S3_BUCKET_NAME)
                .key(UNIVERSITY_VIEW_FOLDER_KEY+request.getUniversityName().toLowerCase().replace(' ','_')+UNIVERSITY_VIEW_KEY)
                .contentType(request.getUniversityLogo().getContentType())
                .build();

        try {
            s3Client.putObject(
                    flagRequest,
                    RequestBody.fromInputStream(
                            request.getUniversityLogo().getInputStream(),
                            request.getUniversityLogo().getSize()
                    )
            );

            s3Client.putObject(
                    viewRequest,
                    RequestBody.fromInputStream(
                            request.getUniversityLogo().getInputStream(),
                            request.getUniversityLogo().getSize()
                    )
            );

        } catch (S3Exception | IOException ex) {
            throw new CountryUploadException();
        }

        UniversityEntity university = getUniversityEntity(request, country);

        universityRepository.save(university);

        UniversitySectionEntity section = new UniversitySectionEntity();
        section.setTitle(request.getUniversityName());
        section.setUniversityEntity(university);
        section.setAreas(request.getArea());
        section.setContent(request.getContent());

        universitySectionRepository.save(section);

        return AddUniversityResponseDTO
                .builder()
                .universityName(request.getUniversityName())
                .isCreated(true)
                .build();
    }

    private static UniversityEntity getUniversityEntity(AddUniversityRequestDTO request, CountryEntity country) {
        UniversityEntity university = new UniversityEntity();
        university.setUniversityName(request.getUniversityName());
        university.setUniversityLogoUrl(S3_PUBLIC_SHARE_LINK+UNIVERSITY_FOLDER_KEY+ request.getUniversityName().toLowerCase().replace(' ','_')+UNIVERSITY_LOGO_KEY);
        university.setUniversityViewUrl(S3_PUBLIC_SHARE_LINK+UNIVERSITY_VIEW_FOLDER_KEY+ request.getUniversityName().toLowerCase().replace(' ','_')+UNIVERSITY_VIEW_KEY);
        university.setType(request.getUniversityType());
        university.setCity(request.getCity());
        university.setCountry(country);
        university.setDescription(request.getShortDescription());
        university.setIsPartner(request.getIsPartner());
        return university;
    }

    @Transactional
    public DeleteUniversityResponseDTO deleteUniversity(DeleteUniversityRequestDTO request) {
        UniversityEntity uni = universityRepository.findByUniversityNameIgnoreCase(request.getUniversityName())
                .orElseThrow(UniversityNotFoundException::new);

        UniversitySectionEntity section = universitySectionRepository.findByUniversityEntity(uni)
                .orElseThrow(UniversityNotFoundException::new);

        List<FacultyEntity> faculties = facultyRepository.findAllByUniversity(uni);

        facultyRepository.deleteAll(faculties);
        facultyRepository.flush();
        universitySectionRepository.delete(section);
        universityRepository.flush();
        universityRepository.delete(uni);

        DeleteObjectRequest deleteObjectRequest =
                DeleteObjectRequest
                        .builder()
                        .bucket(S3_BUCKET_NAME)
                        .key(UNIVERSITY_FOLDER_KEY+request.getUniversityName().toLowerCase().replace(' ', '_')+UNIVERSITY_LOGO_KEY)
                        .build();

        DeleteObjectRequest deleteViewRequest =
                DeleteObjectRequest
                        .builder()
                        .bucket(S3_BUCKET_NAME)
                        .key(UNIVERSITY_VIEW_FOLDER_KEY+request.getUniversityName().toLowerCase().replace(' ', '_')+UNIVERSITY_VIEW_KEY)
                        .build();

        try {
            s3Client.deleteObject(deleteObjectRequest);
            s3Client.deleteObject(deleteViewRequest);
        } catch (S3Exception ex){
            throw new DataDeleteException(DATA_DELETE_S3_UNIVERSITY_MSG);
        }

        return DeleteUniversityResponseDTO
                .builder()
                .universityName(request.getUniversityName())
                .isDeleted(true)
                .build();
    }

}
