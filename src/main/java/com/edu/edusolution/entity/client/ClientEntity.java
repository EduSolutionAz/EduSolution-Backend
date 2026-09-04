package com.edu.edusolution.entity.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.UUID;

@Entity
@Table(
        name = "clients"
)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "client_name", unique = true, nullable = false, length = 50)
    private String clientName;

    @Column(name = "client_email", unique = true,nullable = false,length = 100)
    private String clientEmail;

    @Column(name = "client_number", unique = true, nullable = false, length = 15)
    private String clientNumber;

    @Column(name = "client_password", nullable = false, length = 25)
    private String clientPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_roles", nullable = false)
    private ClientRoles clientRoles;

    @CreationTimestamp
    @Column(name = "client_created_at", insertable = false, updatable = false)
    private String clientCreatedAt;

    @UpdateTimestamp
    @Column(name = "client_updated_at")
    private String clientUpdatedAt;
}
