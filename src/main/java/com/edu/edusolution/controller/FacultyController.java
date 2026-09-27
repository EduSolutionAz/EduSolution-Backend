package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.university.AddNewFacultyRequestDTO;
import com.edu.edusolution.dto.request.university.DeleteFacultyRequestDTO;
import com.edu.edusolution.dto.request.university.UniversityFacultiesRequestDTO;
import com.edu.edusolution.dto.response.university.AddNewFacultyResponseDTO;
import com.edu.edusolution.dto.response.university.DeleteFacultyResponseDTO;
import com.edu.edusolution.dto.response.university.UniversityFacultiesResponseDTO;
import com.edu.edusolution.service.FacultyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @PostMapping("/add")
    public ResponseEntity<AddNewFacultyResponseDTO> addFaculty(@RequestBody @Valid AddNewFacultyRequestDTO request) {
        return ResponseEntity.ok(facultyService.addFaculty(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteFacultyResponseDTO> deleteFaculty(@RequestBody @Valid DeleteFacultyRequestDTO request){
        return ResponseEntity.ok(facultyService.deleteFaculty(request));
    }

    @GetMapping("/get_faculties")
    public ResponseEntity<List<UniversityFacultiesResponseDTO>> getFaculties(@RequestBody @Valid UniversityFacultiesRequestDTO request) {
        return ResponseEntity.ok(facultyService.getUniversityFaculties(request));
    }
}
