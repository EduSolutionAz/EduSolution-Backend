package com.edu.edusolution.repository;

import com.edu.edusolution.entity.applicant.ApplicantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApplicantRepository extends JpaRepository<ApplicantEntity, UUID> {
    List<ApplicantEntity> findTop5ByOrderByCreatedAtDesc();
}
