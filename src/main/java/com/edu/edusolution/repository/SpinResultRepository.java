package com.edu.edusolution.repository;

import com.edu.edusolution.entity.spin.SpinParticipantEntity;
import com.edu.edusolution.entity.spin.SpinResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SpinResultRepository extends JpaRepository<SpinResultEntity, UUID> {

    Optional<SpinResultEntity> findTopByParticipantOrderByCreatedAtDesc(SpinParticipantEntity participant);

    List<SpinResultEntity> findAllOrderByCreatedAt(OffsetDateTime createdAt);

    List<SpinResultEntity> findAllByOrderByCreatedAtDesc();
}
