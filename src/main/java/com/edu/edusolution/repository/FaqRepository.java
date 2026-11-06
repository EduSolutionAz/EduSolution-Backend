package com.edu.edusolution.repository;

import com.edu.edusolution.entity.faq.FaqEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FaqRepository extends JpaRepository<FaqEntity, UUID> {
    Optional<FaqEntity> findByFaqId(UUID faqId);
}
