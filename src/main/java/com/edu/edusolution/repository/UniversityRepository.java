package com.edu.edusolution.repository;

import com.edu.edusolution.entity.university.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UniversityRepository extends JpaRepository<UniversityEntity, UUID> {
}
