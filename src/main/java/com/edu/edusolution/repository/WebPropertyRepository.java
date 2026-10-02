package com.edu.edusolution.repository;

import com.edu.edusolution.entity.web.WebPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WebPropertyRepository extends JpaRepository<WebPropertyEntity, UUID> {
    Optional<WebPropertyEntity> findFirstByOrderByCreatedAtDesc();
}
