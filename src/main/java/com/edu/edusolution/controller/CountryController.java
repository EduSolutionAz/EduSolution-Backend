package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.CountrySectionRequestDTO;
import com.edu.edusolution.dto.response.CountrySectionResponseDTO;
import com.edu.edusolution.dto.response.TopCountriesInfoResponse;
import com.edu.edusolution.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/{countryName}")
    public ResponseEntity<CountrySectionResponseDTO> getCountryInformation(@PathVariable String countryName){
        return ResponseEntity.ok(countryService.getCountryInformation(new CountrySectionRequestDTO(countryName)));
    }

    @GetMapping("/topCountries")
    public ResponseEntity<List<TopCountriesInfoResponse>> getTopCountries(){
        return ResponseEntity.ok(countryService.getTopCountriesInformation());
    }
}
