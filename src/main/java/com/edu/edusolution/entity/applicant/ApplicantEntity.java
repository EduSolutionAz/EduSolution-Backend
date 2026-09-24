package com.edu.edusolution.entity.applicant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "applicants")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "applicant_id")
    private UUID applicantId;
    @Column(name = "applicant_name", nullable = false, length = 100)
    private String applicantName;
    @Column(name = "applicant_email", nullable = false, length = 100)
    private String applicantEmail;
    @Column(name = "applicant_service_type", length = 20)
    @Enumerated(EnumType.STRING)
    private ApplicantServices applicantServiceType;
    @Column(name = "comment", nullable = false, columnDefinition = "TEXT")
    private String comment;
    @CreationTimestamp
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

}
