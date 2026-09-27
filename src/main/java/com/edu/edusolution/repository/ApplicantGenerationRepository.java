package com.edu.edusolution.repository;

import com.edu.edusolution.entity.applicant.ApplicantGenerationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApplicantGenerationRepository extends JpaRepository<ApplicantGenerationEntity, UUID> {
    Optional<ApplicantGenerationEntity> findByTokenHash(String tokenHash);
}
