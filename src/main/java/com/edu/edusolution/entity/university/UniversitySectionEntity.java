package com.edu.edusolution.entity.university;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "university_sections")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UniversitySectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "section_id")
    private UUID sectionId;

    @ManyToOne
    @JoinColumn(name = "university_id", nullable = false)
    private UniversityEntity universityEntity;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private FacultyEntity faculty;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "areas", nullable = false, columnDefinition = "TEXT")
    private String areas;
}
