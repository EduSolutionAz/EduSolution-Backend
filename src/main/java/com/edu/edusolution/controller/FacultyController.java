package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.university.AddNewFacultyRequestDTO;
import com.edu.edusolution.dto.request.university.DeleteFacultyRequestDTO;
import com.edu.edusolution.dto.request.university.UniversityFacultiesRequestDTO;
import com.edu.edusolution.dto.response.university.AddNewFacultyResponseDTO;
import com.edu.edusolution.dto.response.university.DeleteFacultyResponseDTO;
import com.edu.edusolution.dto.response.university.UniversityFacultiesResponseDTO;
import com.edu.edusolution.dto.response.university.UniversityLogoResponseDTO;
import com.edu.edusolution.service.FacultyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faculty")
@RequiredArgsConstructor
@Tag(name = "University Operations", description = "API(s) for university operation, adding, deleting, viewing university and their details")
public class FacultyController {

    private final FacultyService facultyService;

    @PostMapping("/add")
    @Operation(
            summary = "Add a new faculty",
            description = "Creates a new faculty and associates it with a university."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Faculty added successfully",
            content = @Content(
                    schema = @Schema(implementation = AddNewFacultyResponseDTO.class)
            )
    )
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<AddNewFacultyResponseDTO> addFaculty(@RequestBody @Valid AddNewFacultyRequestDTO request) {
        return ResponseEntity.ok(facultyService.addFaculty(request));
    }

    @DeleteMapping("/delete")
    @Operation(
            summary = "Delete a faculty",
            description = "Deletes an existing faculty from a university."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Faculty deleted successfully",
            content = @Content(
                    schema = @Schema(implementation = DeleteFacultyResponseDTO.class)
            )
    )
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DeleteFacultyResponseDTO> deleteFaculty(@RequestBody @Valid DeleteFacultyRequestDTO request){
        return ResponseEntity.ok(facultyService.deleteFaculty(request));
    }

    @GetMapping("/get_faculties")
    @Operation(
            summary = "Get university faculties",
            description = "Retrieves the faculties associated with a specific university."
    )
    @ApiResponse(
            responseCode = "200",
            description = "University faculties retrieved successfully",
            content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = UniversityFacultiesResponseDTO.class)
                    )
            )
    )
    public ResponseEntity<List<UniversityFacultiesResponseDTO>> getFaculties(@RequestBody @Valid UniversityFacultiesRequestDTO request) {
        return ResponseEntity.ok(facultyService.getUniversityFaculties(request));
    }
}
