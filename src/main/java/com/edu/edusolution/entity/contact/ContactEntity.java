package com.edu.edusolution.entity.contact;

import com.edu.edusolution.entity.applicant.ApplicantServices;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "contacts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "contact_id")
    private UUID id;
    @Column(length = 100, nullable = false, name = "contact_name")
    private String name;
    @Column(length = 13, nullable = false, name = "contact_phone_number")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "contact_service", nullable = false)
    private ApplicantServices service;
    @Column(name = "created_at")
    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;
}
