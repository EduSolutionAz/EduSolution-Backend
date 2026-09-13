package com.edu.edusolution.repository;

import com.edu.edusolution.entity.country.CountrySectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountrySectionRepository extends JpaRepository<CountrySectionEntity, UUID> {
}
