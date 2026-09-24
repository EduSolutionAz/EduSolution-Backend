package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.AddNewFacultyRequestDTO;
import com.edu.edusolution.dto.request.DeleteFacultyRequestDTO;
import com.edu.edusolution.dto.request.UniversityFacultiesRequestDTO;
import com.edu.edusolution.dto.response.AddNewFacultyResponseDTO;
import com.edu.edusolution.dto.response.DeleteFacultyResponseDTO;
import com.edu.edusolution.dto.response.UniversityFacultiesResponseDTO;
import com.edu.edusolution.entity.university.FacultyEntity;
import com.edu.edusolution.entity.university.UniversityEntity;
import com.edu.edusolution.exception.FacultyAlreadyExistsException;
import com.edu.edusolution.exception.FacultyNotFoundException;
import com.edu.edusolution.exception.UniversityNotFoundException;
import com.edu.edusolution.repository.FacultyRepository;
import com.edu.edusolution.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;

    public AddNewFacultyResponseDTO addFaculty(AddNewFacultyRequestDTO request) {

        UniversityEntity university = universityRepository.findByUniversityNameIgnoreCase(request.getUniversityName())
                .orElseThrow(UniversityNotFoundException::new);

        Optional<FacultyEntity> faculty = facultyRepository
                .findByFacultyNameIgnoreCaseAndUniversity(request.getFacultyName(),university);

        if(faculty.isPresent()){
            throw new FacultyAlreadyExistsException();
        }

        FacultyEntity newFaculty = new FacultyEntity();
        newFaculty.setFacultyName(request.getFacultyName());
        newFaculty.setUniversity(university);

        facultyRepository.save(newFaculty);

        return AddNewFacultyResponseDTO
                .builder()
                .facultyName(request.getFacultyName())
                .universityName(request.getUniversityName())
                .isCreated(true)
                .build();
    }


    public DeleteFacultyResponseDTO deleteFaculty(DeleteFacultyRequestDTO request) {
        UniversityEntity university = universityRepository.findByUniversityNameIgnoreCase(request.getUniversityName())
                .orElseThrow(UniversityNotFoundException::new);

        FacultyEntity faculty = facultyRepository
                .findByFacultyNameIgnoreCaseAndUniversity(request.getFacultyName(),university)
                .orElseThrow(FacultyNotFoundException::new);

        facultyRepository.delete(faculty);

        return DeleteFacultyResponseDTO
                .builder()
                .facultyName(request.getFacultyName())
                .universityName(request.getUniversityName())
                .isDeleted(true)
                .build();
    }

    public List<UniversityFacultiesResponseDTO> getUniversityFaculties(UniversityFacultiesRequestDTO request) {
        UniversityEntity university = universityRepository.findByUniversityNameIgnoreCase(request.getUniversityName())
                .orElseThrow(UniversityNotFoundException::new);

        List<FacultyEntity> faculty = facultyRepository
                .findAllByUniversity(university);

        return faculty.stream().map(facultyEntity -> new UniversityFacultiesResponseDTO(facultyEntity.getFacultyName())).toList();
    }
}
