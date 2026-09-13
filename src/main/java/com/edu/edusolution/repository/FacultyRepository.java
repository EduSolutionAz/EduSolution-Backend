package com.edu.edusolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FacultyRepository extends JpaRepository<FacultyRepository, UUID> {
}
