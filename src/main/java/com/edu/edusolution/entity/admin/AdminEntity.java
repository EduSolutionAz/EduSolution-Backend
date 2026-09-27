package com.edu.edusolution.entity.admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@Table(name = "admins")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "admin_id")
    private UUID adminId;

    @Column(name = "admin_username", unique = true, nullable = false, length = 50)
    private String adminUsername;

    @Column(name = "admin_email", unique = true, nullable = false, length = 75)
    private String adminEmail;

    @Column(name = "admin_password", nullable = false, length = 72)
    private String adminPassword;

    @CreationTimestamp
    @Column(name = "admin_created_at", insertable = false, updatable = false)
    private OffsetDateTime adminCreatedAt;

    @UpdateTimestamp
    @Column(name = "admin_updated_at")
    private OffsetDateTime adminUpdatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return adminPassword;
    }

    @Override
    public String getUsername() {
        return adminUsername;
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
