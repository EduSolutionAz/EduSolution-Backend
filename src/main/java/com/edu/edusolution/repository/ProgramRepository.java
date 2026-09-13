package com.edu.edusolution.repository;

import com.edu.edusolution.entity.university.ProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProgramRepository extends JpaRepository<ProgramEntity, UUID> {
}
