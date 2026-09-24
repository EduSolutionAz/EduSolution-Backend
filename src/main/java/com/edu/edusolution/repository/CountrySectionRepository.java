package com.edu.edusolution.repository;

import com.edu.edusolution.entity.country.CountryEntity;
import com.edu.edusolution.entity.country.CountrySectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CountrySectionRepository extends JpaRepository<CountrySectionEntity, UUID> {
    Optional<CountrySectionEntity> findByCountry(CountryEntity country);
}
