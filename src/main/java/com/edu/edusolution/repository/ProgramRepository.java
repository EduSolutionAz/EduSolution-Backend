package com.edu.edusolution.repository;

import com.edu.edusolution.entity.university.ProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProgramRepository extends JpaRepository<ProgramEntity, UUID> {
}
