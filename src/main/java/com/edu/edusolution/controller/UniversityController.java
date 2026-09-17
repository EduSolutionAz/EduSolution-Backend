package com.edu.edusolution.controller;

import com.edu.edusolution.dto.response.UniversityLogoResponseDTO;
import com.edu.edusolution.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/university")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping("/university_logos")
    public ResponseEntity<List<UniversityLogoResponseDTO>> getUniversityLogos(){
        return ResponseEntity.ok(universityService.getUniversityLogos());
    }
}
