package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.AddUniversityRequestDTO;
import com.edu.edusolution.dto.request.CountryAddRequestDTO;
import com.edu.edusolution.dto.request.DeleteUniversityRequestDTO;
import com.edu.edusolution.dto.response.AddUniversityResponseDTO;
import com.edu.edusolution.dto.response.DeleteUniversityResponseDTO;
import com.edu.edusolution.dto.response.UniversityLogoResponseDTO;
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
}
