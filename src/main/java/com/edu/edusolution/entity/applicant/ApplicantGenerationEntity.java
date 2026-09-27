package com.edu.edusolution.entity.applicant;

import com.edu.edusolution.entity.client.ClientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "applicant_generations")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApplicantGenerationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "token_hash", nullable = false, length = 64)
    private String tokenHash;
    @Column(name = "client_name", nullable = false, length = 100)
    private String clientName;
    @Column(name = "client_email", nullable = false, length = 100)
    private String clientEmail;
    @Column(name = "expires_at", nullable = false)
    private OffsetDateTime expiresAt;
    @Column(name = "is_used", nullable = false)
    private boolean used;
    @CreationTimestamp
    private OffsetDateTime createdAt;
}
