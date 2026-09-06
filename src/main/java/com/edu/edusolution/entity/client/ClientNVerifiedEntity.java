package com.edu.edusolution.entity.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "clients_nverified"
)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientNVerifiedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "client_nverified_id")
    private UUID clientId;

    // Data will be used
    @Column(name = "client_name", unique = true, nullable = false, length = 50)
    private String clientName;

    @Column(name = "client_email", unique = true, nullable = false, length = 100)
    private String clientEmail;
    //---------------------

    @Column(name = "client_number", unique = true, nullable = false, length = 15)
    private String clientNumber;

    @Column(name = "client_code", nullable = false, length = 6)
    private String clientCode;

    @Column(name = "client_code_expire", nullable = false)
    private OffsetDateTime clientCodeExpire;

    @Column(name = "client_code_last_sent", nullable = false)
    private OffsetDateTime clientCodeLastSent;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_state", nullable = false)
    private PendingState accountState;

    @CreationTimestamp
    @Column(name = "client_created_at", insertable = false, updatable = false)
    private OffsetDateTime clientCreatedAt;
}
