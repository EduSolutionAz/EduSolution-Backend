package com.edu.edusolution.entity.country;

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
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "country_id")
    private UUID countryId;

    @Column(name = "country_name", nullable = false, unique = true)
    private String countryName;

    @Column(name = "country_flag_url", nullable = false)
    private String countryFlagUrl;

    @Column(name = "country_photo_url", nullable = false)
    private String countryPhotoUrl;

    @Column(name = "university_count", nullable = false)
    private int universityCount;

    @Column(name = "tuition_fee_entry", nullable = false)
    private BigDecimal tuitionFeeEntry;

    @Column(name = "rental_fee_entry")
    private BigDecimal rentalFeeEntry;

    @Column(name = "visa_help", nullable = false)
    private boolean visaHelp;

    @Column(name = "dormitory_help", nullable = false)
    private boolean dormitoryHelp;

    @Column(name = "top_list")
    private boolean topList;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}
