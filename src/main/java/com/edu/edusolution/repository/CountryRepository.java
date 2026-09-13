package com.edu.edusolution.repository;

import com.edu.edusolution.entity.country.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, UUID> {
    Optional<CountryEntity> findByCountryName(String countryName);

    List<CountryEntity> findTop10By();

    Optional<CountryEntity> findByCountryNameIgnoreCase(String countryName);
}
