package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.AddWebPropertiesRequestDTO;
import com.edu.edusolution.dto.response.AddWebPropertiesResponseDTO;
import com.edu.edusolution.dto.response.WebPropertiesResponseDTO;
import com.edu.edusolution.service.WebPropertyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/property")
@RequiredArgsConstructor
@Tag(name = "Property Operations", description = "API(s) for little properties at website such as visa help, admission number, success rates, and etc.")
public class WebPropertyController {

    private final WebPropertyService webPropertyService;

    @GetMapping("/all")
    @Operation(
            summary = "Get web properties",
            description = "Retrieves the web properties and configuration information used by the platform."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Web properties retrieved successfully",
            content = @Content(
                    schema = @Schema(implementation = WebPropertiesResponseDTO.class)
            )
    )
    public ResponseEntity<WebPropertiesResponseDTO> getProperties(){
        return ResponseEntity.ok(webPropertyService.getProperties());
    }

    @PostMapping("/add")
    @Operation(
            summary = "Add a web property",
            description = "Creates and stores a new web property for the platform."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Web property created successfully",
            content = @Content(
                    schema = @Schema(implementation = AddWebPropertiesResponseDTO.class)
            )
    )
    public ResponseEntity<AddWebPropertiesResponseDTO> addProperty(@RequestBody @Valid AddWebPropertiesRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(webPropertyService.addProperty(request));
    }
}
