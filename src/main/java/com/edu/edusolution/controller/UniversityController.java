package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.university.AddUniversityRequestDTO;
import com.edu.edusolution.dto.request.university.DeleteUniversityRequestDTO;
import com.edu.edusolution.dto.request.university.UniversityByCountryRequestDTO;
import com.edu.edusolution.dto.response.university.*;
import com.edu.edusolution.service.UniversityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/university")
@RequiredArgsConstructor
@Tag(name = "University Operations", description = "API(s) for university operation, adding, deleting, viewing university and their details")
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping("/university_logos")
    @Operation(
            summary = "Get university logos",
            description = "Retrieves the logos of universities available on the platform."
    )
    @ApiResponse(
            responseCode = "200",
            description = "University logos retrieved successfully",
            content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = UniversityLogoResponseDTO.class)
                    )
            )
    )
    public ResponseEntity<List<UniversityLogoResponseDTO>> getUniversityLogos(){
        return ResponseEntity.ok(universityService.getUniversityLogos());
    }

    @PostMapping(value = "/add_university",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Add a new university",
            description = "Creates a new university and uploads its associated information and files."
    )
    @ApiResponse(
            responseCode = "200",
            description = "University added successfully",
            content = @Content(
                    schema = @Schema(implementation = AddUniversityResponseDTO.class)
            )
    )
    public ResponseEntity<AddUniversityResponseDTO> addUniversity(@ModelAttribute AddUniversityRequestDTO request){
        return ResponseEntity.ok(universityService.addUniversity(request));
    }

    @DeleteMapping("/delete_university")
    @Operation(
            summary = "Delete a university",
            description = "Deletes a university and its associated information."
    )
    @ApiResponse(
            responseCode = "200",
            description = "University deleted successfully",
            content = @Content(
                    schema = @Schema(implementation = DeleteUniversityResponseDTO.class)
            )
    )
    public ResponseEntity<DeleteUniversityResponseDTO> deleteUniversity(@RequestBody @Valid DeleteUniversityRequestDTO request){
        return ResponseEntity.ok(universityService.deleteUniversity(request));
    }

    @GetMapping("/university_details/{universityName}")
    @Operation(
            summary = "Get university information",
            description = "Retrieves detailed information about a specific university."
    )
    @ApiResponse(
            responseCode = "200",
            description = "University information retrieved successfully",
            content = @Content(
                    schema = @Schema(implementation = UniversitySectionResponseDTO.class)
            )
    )
    public ResponseEntity<UniversitySectionResponseDTO> getUniversitySection(@PathVariable String universityName) {
        return ResponseEntity.ok(universityService.getUniversityInformation(universityName));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UniversitiesResponseDTO>> getAllUniversities(){
        return ResponseEntity.ok(universityService.getAllUniversities());
    }

    @GetMapping("/all_by_country")
    public ResponseEntity<List<UniversitiesResponseDTO>> getAllUniversitiesByCountry(@RequestBody @Valid UniversityByCountryRequestDTO request) {
        return ResponseEntity.ok(universityService.getUniversitiesByCountry(request.getCountryName()));
    }
}
