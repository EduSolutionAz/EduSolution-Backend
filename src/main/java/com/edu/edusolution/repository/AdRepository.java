package com.edu.edusolution.repository;

import com.edu.edusolution.entity.ad.AdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AdRepository extends JpaRepository<AdEntity, UUID> {
    Optional<AdEntity> findByTitleIgnoreCase(String title);

    List<AdEntity> findTop5ByOrderByCreatedAtDesc();
}
