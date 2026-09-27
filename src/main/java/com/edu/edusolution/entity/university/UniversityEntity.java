package com.edu.edusolution.entity.university;

import com.edu.edusolution.entity.country.CountryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
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

    @Column(name = "university_entry_fee", precision = 7, scale = 2)
    private BigDecimal entryFee;

    @Column(name = "university_logo_url")
    private String universityLogoUrl;

    @Column(name = "university_view_url")
    private String universityViewUrl;

    @Column(nullable = false)
    private String city;

    @Column(name = "is_partner")
    private Boolean isPartner;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}
