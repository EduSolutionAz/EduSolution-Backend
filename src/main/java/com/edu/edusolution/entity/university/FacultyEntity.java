package com.edu.edusolution.entity.university;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "faculties")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacultyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "faculty_id")
    private UUID facultyId;

    @ManyToOne
    @JoinColumn(name = "university_id", nullable = false)
    private UniversityEntity university;

    @Column(name = "faculty_name", nullable = false)
    private String facultyName;

}
