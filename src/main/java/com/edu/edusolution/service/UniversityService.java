package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.AddUniversityRequestDTO;
import com.edu.edusolution.dto.request.DeleteUniversityRequestDTO;
import com.edu.edusolution.dto.request.UniversitySectionRequestDTO;
import com.edu.edusolution.dto.response.AddUniversityResponseDTO;
import com.edu.edusolution.dto.response.DeleteUniversityResponseDTO;
import com.edu.edusolution.dto.response.UniversityLogoResponseDTO;
import com.edu.edusolution.dto.response.UniversitySectionResponseDTO;
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
        List<UniversityEntity> universityEntities = universityRepository.findTop10By();

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

    public UniversitySectionResponseDTO getUniversityInformation(UniversitySectionRequestDTO request) {
        UniversityEntity checkUni = universityRepository.findByUniversityName(request.getUniversityName())
                .orElseThrow(UniversityNotFoundException::new);

        UniversitySectionEntity checkSection = universitySectionRepository.findByUniversityEntity(checkUni)
                .orElseThrow(UniversityNotFoundException::new);

        List<FacultyEntity> faculties = facultyRepository.findAllByUniversity(checkUni);
        List<String> facultiesString = faculties.stream().map(FacultyEntity::getFacultyName).toList();

        return UniversitySectionResponseDTO.builder()
                .title(request.getUniversityName())
                .content(checkSection.getContent())
                .photoUrl(checkUni.getUniversityLogoUrl())
                .faculties(facultiesString)
                .build();
    }

    @Transactional
    public AddUniversityResponseDTO addUniversity(AddUniversityRequestDTO request) {
        Optional<UniversityEntity> checkUni = universityRepository.findByUniversityName(request.getUniversityName());

        if (checkUni.isPresent()){
            throw new UniversityAlreadyExistsException();
        }

        CountryEntity country = countryRepository.findByCountryName(request.getCountryName())
                .orElseThrow(CountryNotFoundException::new);

        PutObjectRequest flagRequest = PutObjectRequest
                .builder()
                .bucket(S3_BUCKET_NAME)
                .key(UNIVERSITY_FOLDER_KEY+request.getUniversityName().toLowerCase().replace(' ','_')+UNIVERSITY_LOGO_KEY)
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

        } catch (S3Exception | IOException ex) {
            throw new CountryUploadException();
        }

        UniversityEntity university = new UniversityEntity();
        university.setUniversityName(request.getUniversityName());
        university.setUniversityLogoUrl(S3_PUBLIC_SHARE_LINK+UNIVERSITY_FOLDER_KEY+ request.getUniversityName().toLowerCase()+UNIVERSITY_LOGO_KEY);
        university.setType(request.getUniversityType());
        university.setCity(request.getCity());
        university.setCountry(country);
        university.setDescription(request.getShortDescription());

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

    @Transactional
    public DeleteUniversityResponseDTO deleteUniversity(DeleteUniversityRequestDTO request) {
        UniversityEntity uni = universityRepository.findByUniversityNameIgnoreCase(request.getUniversityName())
                .orElseThrow(UniversityNotFoundException::new);

        UniversitySectionEntity section = universitySectionRepository.findByUniversityEntity(uni)
                .orElseThrow(UniversityNotFoundException::new);

        universitySectionRepository.delete(section);
        universityRepository.delete(uni);

        DeleteObjectRequest deleteObjectRequest =
                DeleteObjectRequest
                        .builder()
                        .bucket(S3_BUCKET_NAME)
                        .key(UNIVERSITY_FOLDER_KEY+request.getUniversityName().toLowerCase().replace(' ', '_')+UNIVERSITY_LOGO_KEY)
                        .build();

        try {
            s3Client.deleteObject(deleteObjectRequest);
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
