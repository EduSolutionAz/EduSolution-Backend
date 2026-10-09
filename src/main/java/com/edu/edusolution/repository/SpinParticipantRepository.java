package com.edu.edusolution.repository;

import com.edu.edusolution.entity.spin.SpinParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpinParticipantRepository extends JpaRepository<SpinParticipantEntity, UUID> {

    Optional<SpinParticipantEntity> findByBrowserId(UUID browserId);

    Optional<SpinParticipantEntity> findByIp(String ip);

    Optional<SpinParticipantEntity> findTop1ByBrowserIdOrderByCreatedAtDesc(UUID browserId);
}
