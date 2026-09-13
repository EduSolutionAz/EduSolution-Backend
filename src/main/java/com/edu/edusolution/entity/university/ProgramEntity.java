package com.edu.edusolution.entity.university;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "programs")
public class ProgramEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "program_id")
    private UUID programId;

    @ManyToOne
    @JoinColumn(name = "university_id", nullable = false)
    private UniversityEntity university;

    @Column(name = "program_name", nullable = false)
    private String programName;

    @Column(name = "fee")
    private BigDecimal fee;

    @Column(name = "semester_count", nullable = false)
    private int semesterCount;
}
