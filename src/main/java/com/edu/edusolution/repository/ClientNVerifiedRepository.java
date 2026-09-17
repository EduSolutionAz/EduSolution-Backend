package com.edu.edusolution.repository;

import com.edu.edusolution.entity.client.ClientNVerifiedEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientNVerifiedRepository extends CrudRepository<ClientNVerifiedEntity, UUID> {
    Optional<ClientNVerifiedEntity> findByClientEmail(String clientEmail);

    Optional<ClientNVerifiedEntity> findByClientEmailAndClientNumber(String clientEmail, String clientNumber);

    Optional<ClientNVerifiedEntity> findByClientEmailOrClientNumber(@NotBlank(message = "email is required") @NotNull(message = "email is required") @Size(max = 50, message = "email must not exceed 50 characters") @Email(message = "email must be a valid email address") String clientEmail, @NotBlank(message = "phone is required") @NotNull(message = "phone is required") @Size(max = 15, message = "phone number must not exceed 10 characters") String clientPhone);
}
