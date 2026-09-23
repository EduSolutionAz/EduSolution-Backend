package com.edu.edusolution.service;

import com.edu.edusolution.dto.response.UniversityLogoResponseDTO;
import com.edu.edusolution.entity.university.UniversityEntity;
import com.edu.edusolution.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final UniversityRepository universityRepository;

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
}
