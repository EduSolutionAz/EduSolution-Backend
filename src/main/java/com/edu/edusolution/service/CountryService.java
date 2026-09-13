package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.CountrySectionRequestDTO;
import com.edu.edusolution.dto.response.CountrySectionResponseDTO;
import com.edu.edusolution.dto.response.TopCountriesInfoResponse;
import com.edu.edusolution.entity.country.CountryEntity;
import com.edu.edusolution.entity.country.CountrySectionEntity;
import com.edu.edusolution.entity.university.UniversityEntity;
import com.edu.edusolution.exception.CountryNotFoundException;
import com.edu.edusolution.repository.CountryRepository;
import com.edu.edusolution.repository.CountrySectionRepository;
import com.edu.edusolution.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountrySectionRepository countrySectionRepository;
    private final UniversityRepository universityRepository;


    public CountrySectionResponseDTO getCountryInformation(CountrySectionRequestDTO request) {
        CountryEntity country = countryRepository.findByCountryNameIgnoreCase(request.getCountryName())
                .orElseThrow
                        (
                                CountryNotFoundException::new
                        );

        CountrySectionEntity section = countrySectionRepository.findByCountry(country)
                .orElseThrow
                        (
                                CountryNotFoundException::new
                        );

        List<String> universities = universityRepository.findAllByCountry(country).stream()
                .map(UniversityEntity::getUniversityName)
                .toList();


        return CountrySectionResponseDTO
                .builder()
                .title(country.getCountryName())
                .photoUrl(country.getCountryPhotoUrl())
                .title(section.getTitle())
                .content(section.getContent())
                .universities(universities)
                .areas(section.getAreas())
                .build();
    }

    public List<TopCountriesInfoResponse> getTopCountriesInformation(){
        List<CountryEntity> countries = countryRepository.findTop10By();

        return countries.stream()
                .map(countryEntity -> TopCountriesInfoResponse
                        .builder()
                        .countryName(countryEntity.getCountryName())
                        .countryBGUrl(countryEntity.getCountryPhotoUrl())
                        .dormitoryHelp(countryEntity.isDormitoryHelp())
                        .universityCount(countryEntity.getUniversityCount())
                        .visaHelp(countryEntity.isVisaHelp())
                        .build()
                )
                .toList();
    }
}
