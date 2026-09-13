package com.edu.edusolution.entity.university;

import com.edu.edusolution.entity.country.CountryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "universities")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UniversityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "university_id")
    private UUID universityId;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @Column(name = "university_name", nullable = false, unique = true)
    private String universityName;

    @Column(name = "university_type")
    @Enumerated(EnumType.STRING)
    private UniversityType type;

    @Column(nullable = false)
    private String description;

    @Column(name = "university_logo_url")
    private String universityLogoUrl;

    @Column(nullable = false)
    private String city;
}
