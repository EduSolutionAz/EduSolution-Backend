package com.edu.edusolution.repository;

import com.edu.edusolution.entity.contact.ContactEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import static com.edu.edusolution.constants.DtoConstants.*;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, UUID> {
    Optional<ContactEntity> findByNameOrPhoneNumberOrderByCreatedAtDesc(@NotBlank(message = NAME_IS_REQUIRED_MSG) @NotNull(message = NAME_IS_REQUIRED_MSG) @Size(max = 100, message = NAME_FULL_LENGTH_MSG) String name, @NotBlank(message = PHONE_IS_REQUIRED_MSG) @NotNull(message = PHONE_IS_REQUIRED_MSG) @Size(max = 15, min = 9, message = PHONE_LENGTH_MSG) String phone);

    Optional<ContactEntity> findByPhoneNumberOrderByCreatedAtDesc(@NotBlank(message = PHONE_IS_REQUIRED_MSG) @NotNull(message = PHONE_IS_REQUIRED_MSG) @Size(max = 15, min = 9, message = PHONE_LENGTH_MSG) String phone);
}
