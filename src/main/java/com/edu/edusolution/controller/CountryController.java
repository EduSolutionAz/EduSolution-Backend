package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.CountryAddRequestDTO;
import com.edu.edusolution.dto.request.CountrySectionRequestDTO;
import com.edu.edusolution.dto.request.DeleteCountryRequestDTO;
import com.edu.edusolution.dto.response.*;
import com.edu.edusolution.service.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/{countryName}")
    public ResponseEntity<CountrySectionResponseDTO> getCountryInformation(@PathVariable String countryName) {
        System.out.println(countryName);
        return ResponseEntity.ok(countryService.getCountryInformation(new CountrySectionRequestDTO(countryName)));
    }

    @GetMapping("/top_countries")
    public ResponseEntity<List<TopCountriesInfoResponse>> getTopCountries() {
        return ResponseEntity.ok(countryService.getTopCountriesInformation());
    }

    @GetMapping("/country_logos")
    public ResponseEntity<List<CountryFlagResponseDTO>> getCountryFlags() {
        return ResponseEntity.ok(countryService.getCountryTopFlags());
    }

    @PostMapping(value = "/add_country", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CountryAddResponseDTO> addCountry(@ModelAttribute CountryAddRequestDTO request) {
        System.out.println(request.getTuitionFee());
        System.out.println(request.getCountryName());
        return ResponseEntity.ok(countryService.addNewCountry(request));
    }

    @DeleteMapping("/delete_country")
    public ResponseEntity<DeleteCountryResponseDTO> deleteCountry(@RequestBody @Valid DeleteCountryRequestDTO request) {
        return ResponseEntity.ok(countryService.deleteCountry(request));
    }
}
