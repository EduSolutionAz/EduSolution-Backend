package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.university.AddNewFacultyRequestDTO;
import com.edu.edusolution.dto.request.university.DeleteFacultyRequestDTO;
import com.edu.edusolution.dto.request.university.UniversityFacultiesRequestDTO;
import com.edu.edusolution.dto.response.university.AddNewFacultyResponseDTO;
import com.edu.edusolution.dto.response.university.DeleteFacultyResponseDTO;
import com.edu.edusolution.dto.response.university.UniversityFacultiesResponseDTO;
import com.edu.edusolution.entity.university.FacultyEntity;
import com.edu.edusolution.entity.university.UniversityEntity;
import com.edu.edusolution.exception.FacultyAlreadyExistsException;
import com.edu.edusolution.exception.FacultyNotFoundException;
import com.edu.edusolution.exception.UniversityNotFoundException;
import com.edu.edusolution.repository.FacultyRepository;
import com.edu.edusolution.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;

    public AddNewFacultyResponseDTO addFaculty(AddNewFacultyRequestDTO request) {

        UniversityEntity university = universityRepository.findByUniversityNameIgnoreCase(request.getUniversityName().replace(' ','_').replace('-','_'))
                .orElseThrow(UniversityNotFoundException::new);

        Optional<FacultyEntity> faculty = facultyRepository
                .findByFacultyNameIgnoreCaseAndUniversity(request.getFacultyName().replace(' ','_').replace('-','_'),university);

        if(faculty.isPresent()){
            throw new FacultyAlreadyExistsException();
        }

        FacultyEntity newFaculty = new FacultyEntity();
        newFaculty.setFacultyName(request.getFacultyName().replace(' ','_').replace('-','_'));
        newFaculty.setUniversity(university);

        facultyRepository.save(newFaculty);

        log.info("Faculty added {}", newFaculty.getFacultyName());

        return AddNewFacultyResponseDTO
                .builder()
                .facultyName(request.getFacultyName())
                .universityName(request.getUniversityName())
                .isCreated(true)
                .build();
    }


    public DeleteFacultyResponseDTO deleteFaculty(DeleteFacultyRequestDTO request) {
        UniversityEntity university = universityRepository.findByUniversityNameIgnoreCase(request.getUniversityName().replace(' ','_').replace('-','_'))
                .orElseThrow(UniversityNotFoundException::new);

        FacultyEntity faculty = facultyRepository
                .findByFacultyNameIgnoreCaseAndUniversity(request.getFacultyName().replace(' ','_').replace('-','_'),university)
                .orElseThrow(FacultyNotFoundException::new);

        facultyRepository.delete(faculty);

        log.info("Faculty is deleted {}", faculty.getFacultyName());

        return DeleteFacultyResponseDTO
                .builder()
                .facultyName(request.getFacultyName())
                .universityName(request.getUniversityName())
                .isDeleted(true)
                .build();
    }

    public List<UniversityFacultiesResponseDTO> getUniversityFaculties(UniversityFacultiesRequestDTO request) {
        UniversityEntity university = universityRepository.findByUniversityNameIgnoreCase(request.getUniversityName().replace(' ','_').replace('-','_'))
                .orElseThrow(UniversityNotFoundException::new);

        List<FacultyEntity> faculty = facultyRepository
                .findAllByUniversity(university);

        return faculty.stream().map(facultyEntity -> new UniversityFacultiesResponseDTO(facultyEntity.getFacultyName().replace('_',' '))).toList();
    }
}
