package com.edu.edusolution.entity.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(
        name = "clients"
)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientEntity implements UserDetails {

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

    @Column(name = "client_password", nullable = false, length = 72)
    private String clientPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_roles", nullable = false)
    private ClientRoles clientRoles;

    @CreationTimestamp
    @Column(name = "client_created_at", insertable = false, updatable = false)
    private OffsetDateTime clientCreatedAt;

    @UpdateTimestamp
    @Column(name = "client_updated_at")
    private OffsetDateTime clientUpdatedAt;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return clientPassword;
    }

    @Override
    public String getUsername() {
        return clientEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
