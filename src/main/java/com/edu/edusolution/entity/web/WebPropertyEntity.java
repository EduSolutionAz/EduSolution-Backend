package com.edu.edusolution.entity.web;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "web_properties")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WebPropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "property_id")
    private UUID propertyId;

    @Column(name = "student_helped", nullable = false)
    private int studentHelped;

    @Column(name = "visa_success_rate", nullable = false, precision = 5, scale = 2)
    private BigDecimal visaSuccessRate;

    @Column(name = "admission_sent", nullable = false)
    private int admissionSent;

    @Column(name = "successful_admission", nullable = false)
    private int successfulAdmission;

    @Column(name = "visa_help", nullable = false)
    private int visaHelp;

    @Column(name = "successful_visa_help", nullable = false)
    private int successfulVisaHelp;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;
}
