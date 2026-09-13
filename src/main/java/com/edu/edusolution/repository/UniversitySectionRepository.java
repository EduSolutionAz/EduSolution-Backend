package com.edu.edusolution.repository;

import com.edu.edusolution.entity.university.UniversitySectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UniversitySectionRepository extends JpaRepository<UniversitySectionEntity, UUID> {
}
