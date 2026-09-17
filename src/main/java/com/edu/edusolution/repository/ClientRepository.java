package com.edu.edusolution.repository;

import com.edu.edusolution.entity.client.ClientEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
    Optional<ClientEntity> findByClientEmail(String clientEmail);

    Optional<ClientEntity> findByClientEmailOrClientNumber(@NotBlank(message = "email is required") @NotNull(message = "email is required") @Size(max = 50, message = "email must not exceed 50 characters") @Email(message = "email must be a valid email address") String clientEmail, @NotBlank(message = "phone is required") @NotNull(message = "phone is required") @Size(max = 15, message = "phone number must not exceed 10 characters") String clientPhone);
}
