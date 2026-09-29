package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.country.*;
import com.edu.edusolution.dto.response.country.*;
import com.edu.edusolution.dto.response.university.AddNewFacultyResponseDTO;
import com.edu.edusolution.dto.response.university.CountryEntityResponseDTO;
import com.edu.edusolution.dto.response.university.UniversityFacultiesResponseDTO;
import com.edu.edusolution.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
@RequiredArgsConstructor
@Tag(name = "Country Operations", description = "API(s) for country operation, adding, deleting")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/country_detail/{countryName}")
    @Operation(
            summary = "Get country information",
            description = "Retrieves detailed information about a specific country."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Country information retrieved successfully",
            content = @Content(
                    schema = @Schema(implementation = CountrySectionResponseDTO.class)
            )
    )
    public ResponseEntity<CountrySectionResponseDTO> getCountryInformation(@PathVariable String countryName) {
        System.out.println(countryName);
        return ResponseEntity.ok(countryService.getCountryInformation(new CountrySectionRequestDTO(countryName)));
    }

    @GetMapping("/top_countries")
    @Operation(
            summary = "Get top countries",
            description = "Retrieves a list of the top countries available on the platform."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Top countries retrieved successfully",
            content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = TopCountriesInfoResponse.class)
                    )
            )
    )
    public ResponseEntity<List<TopCountriesInfoResponse>> getTopCountries() {
        return ResponseEntity.ok(countryService.getTopCountriesInformation());
    }

    @GetMapping("/country_logos")
    @Operation(
            summary = "Get country flags",
            description = "Retrieves the flags of the countries displayed in the country section."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Country flags retrieved successfully",
            content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = CountryFlagResponseDTO.class)
                    )
            )
    )
    public ResponseEntity<List<CountryFlagResponseDTO>> getCountryFlags() {
        return ResponseEntity.ok(countryService.getCountryTopFlags());
    }

    @PostMapping(value = "/add_country", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Add a new country",
            description = "Creates a new country and uploads its associated information and files."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Country added successfully",
            content = @Content(
                    schema = @Schema(implementation = CountryAddResponseDTO.class)
            )
    )
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CountryAddResponseDTO> addCountry(@ModelAttribute CountryAddRequestDTO request) {
        System.out.println(request.getTuitionFee());
        System.out.println(request.getCountryName());
        return ResponseEntity.ok(countryService.addNewCountry(request));
    }

    @DeleteMapping("/delete_country")
    @Operation(
            summary = "Delete a country",
            description = "Deletes a country and its associated information."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Country deleted successfully",
            content = @Content(
                    schema = @Schema(implementation = DeleteCountryResponseDTO.class)
            )
    )
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<DeleteCountryResponseDTO> deleteCountry(@RequestBody @Valid DeleteCountryRequestDTO request) {
        return ResponseEntity.ok(countryService.deleteCountry(request));
    }

    @PatchMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Update a country",
            description = "Updates the information of an existing country."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Country updated successfully",
            content = @Content(
                    schema = @Schema(implementation = UpdateCountryResponseDTO.class)
            )
    )
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<UpdateCountryResponseDTO> updateCountry(@ModelAttribute UpdateCountryRequestDTO request) {
        return ResponseEntity.ok(countryService.updateCountry(request));
    }

    @GetMapping("/country_entity/{countryName}")
    @Operation(
            summary = "Get country entity",
            description = "Retrieves the entity information for a specified country."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Country entity retrieved successfully",
            content = @Content(
                    schema = @Schema(implementation = CountryEntityResponseDTO.class)
            )
    )
    public ResponseEntity<CountryEntityResponseDTO> getCountryEntity(@PathVariable String countryName) {
        return ResponseEntity.ok(countryService.countryEntity(new CountryEntityRequestDTO(countryName)));
    }

    @Operation(
            summary = "Get all countries",
            description = "Retrieves a list of all countries available on the platform."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Countries retrieved successfully",
            content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = CountriesResponseDTO.class)
                    )
            )
    )
    @GetMapping("/all")
    public ResponseEntity<List<CountriesResponseDTO>> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

}
