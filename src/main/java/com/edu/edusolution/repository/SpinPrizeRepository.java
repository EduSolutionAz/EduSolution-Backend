package com.edu.edusolution.repository;

import com.edu.edusolution.entity.spin.SpinPrizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpinPrizeRepository extends JpaRepository<SpinPrizeEntity, UUID> {

    Optional<SpinPrizeEntity> findBySpinPrizeNameIgnoreCase(String spinPrizeName);
}
