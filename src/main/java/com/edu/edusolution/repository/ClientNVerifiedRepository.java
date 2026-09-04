package com.edu.edusolution.repository;

import com.edu.edusolution.entity.client.ClientNVerifiedEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientNVerifiedRepository extends CrudRepository<ClientNVerifiedEntity, UUID> {
    Optional<ClientNVerifiedEntity> findByClientEmail(String clientEmail);

    Optional<ClientNVerifiedEntity> findByClientEmailAndClientNumber(String clientEmail, String clientNumber);
}
