package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.university.AddUniversityRequestDTO;
import com.edu.edusolution.dto.request.university.DeleteUniversityRequestDTO;
import com.edu.edusolution.dto.response.university.AddUniversityResponseDTO;
import com.edu.edusolution.dto.response.university.DeleteUniversityResponseDTO;
import com.edu.edusolution.dto.response.university.UniversityLogoResponseDTO;
import com.edu.edusolution.dto.response.university.UniversitySectionResponseDTO;
import com.edu.edusolution.service.UniversityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/add_university",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AddUniversityResponseDTO> addUniversity(@ModelAttribute AddUniversityRequestDTO request){
        return ResponseEntity.ok(universityService.addUniversity(request));
    }

    @DeleteMapping("/delete_university")
    public ResponseEntity<DeleteUniversityResponseDTO> deleteUniversity(@RequestBody @Valid DeleteUniversityRequestDTO request){
        return ResponseEntity.ok(universityService.deleteUniversity(request));
    }

    @GetMapping("/university_details/{universityName}")
    public ResponseEntity<UniversitySectionResponseDTO> getUniversitySection(@PathVariable String universityName) {
        return ResponseEntity.ok(universityService.getUniversityInformation(universityName));
    }
}
