package com.edu.edusolution.repository;

import com.edu.edusolution.entity.university.FacultyEntity;
import com.edu.edusolution.entity.university.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity, UUID> {
    List<FacultyEntity> findAllByUniversity(UniversityEntity university);
}
