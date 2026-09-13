package com.edu.edusolution.repository;

import com.edu.edusolution.entity.university.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity, UUID> {
}
