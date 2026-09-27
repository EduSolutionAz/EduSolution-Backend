package com.edu.edusolution.service;

import com.edu.edusolution.dto.ErrorDto;
import com.edu.edusolution.dto.request.CreateContactRequestDTO;
import com.edu.edusolution.dto.response.CreateContactResponseDTO;
import com.edu.edusolution.entity.contact.ContactEntity;
import com.edu.edusolution.repository.ContactRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final MailService mailService;

    @Transactional
    public CreateContactResponseDTO createContact(CreateContactRequestDTO request) {

        Optional<ContactEntity> checkContact = contactRepository
                .findByPhoneNumberOrderByCreatedAtDesc(request.getPhone());

        if(checkContact.isPresent() && checkContact.get().getCreatedAt().isBefore(OffsetDateTime.now().plusMinutes(15))) {
            return CreateContactResponseDTO
                    .builder()
                    .name(request.getName())
                    .isCreated(false)
                    .errors(
                            List.of(
                                    new ErrorDto("Contact with this phone number already sent. Please wait at least 1 day to send a new contact")
                            )
                    )
                    .build();
        }

        ContactEntity contact = new ContactEntity();
        contact.setService(request.getService());
        contact.setName(request.getName());
        contact.setPhoneNumber(request.getPhone());

        contactRepository.save(contact);

        mailService.sendPlainText("alinurmammadzada@gmail.com","New Contact Request", "New Contact request \n phone number : "+request.getPhone() +"\n name + " +request.getName()+"\n service : "+request.getService());

        return CreateContactResponseDTO
                .builder()
                .isCreated(true)
                .name(request.getName())
                .errors(List.of())
                .build();
    }
}
