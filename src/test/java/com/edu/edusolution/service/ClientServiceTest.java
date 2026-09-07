package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.ClientPasswordCreationRequestDTO;
import com.edu.edusolution.dto.request.ClientRegisterRequestDTO;
import com.edu.edusolution.dto.request.ClientVerificationRequestDTO;
import com.edu.edusolution.dto.response.ClientPasswordCreationResponseDTO;
import com.edu.edusolution.dto.response.ClientRegisterResponseDTO;
import com.edu.edusolution.dto.response.ClientVerificationResponseDTO;
import com.edu.edusolution.entity.client.ClientEntity;
import com.edu.edusolution.entity.client.ClientNVerifiedEntity;
import com.edu.edusolution.entity.client.PendingState;
import com.edu.edusolution.exception.ClientAlreadyExistsException;
import com.edu.edusolution.exception.ClientNotFoundException;
import com.edu.edusolution.exception.VerificationFailedException;
import com.edu.edusolution.repository.ClientNVerifiedRepository;
import com.edu.edusolution.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.OffsetDateTime;
import java.util.Optional;

import static com.edu.edusolution.constants.ExceptionConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(classes = ClientService.class)
public class ClientServiceTest {

    @MockitoBean
    private ClientRepository clientRepository;
    @MockitoBean
    private ClientNVerifiedRepository clientNVerifiedRepository;
    @MockitoBean
    private  MailService mailService;
    @MockitoBean
    private  AuthenticationManager authenticationManager;
    @MockitoBean
    private  JwtService jwtService;
    @MockitoBean
    private  AuthenticationService authenticationService;
    @MockitoBean
    private  BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ClientService clientService;

    @Test
    public void shouldSendEmailWhenRegisterSuccessful(){
        String email = "user@example.com";
        String name = "user";
        String phone = "+48123456789";

        when(clientRepository.findByClientEmailOrClientNumber(email, phone)).thenReturn(Optional.empty());
        when(clientNVerifiedRepository.findByClientEmailOrClientNumber(email, phone)).thenReturn(Optional.empty());

        ClientRegisterResponseDTO response = clientService.clientRegister(ClientRegisterRequestDTO.builder().clientEmail(email).clientName(name).clientPhone(phone).build());

        assertTrue(response.isCodeSent());
    }

    @Test
    public void shouldSendEmailWhenPendingClientNotCooldown(){
        String email = "user@example.com";
        String name = "user";
        String phone = "+48123456789";

        ClientNVerifiedEntity client = new ClientNVerifiedEntity();
        client.setClientEmail(email);
        client.setClientName(name);
        client.setClientNumber(phone);
        client.setClientCodeLastSent(OffsetDateTime.now().minusMinutes(2));
        client.setAccountState(PendingState.VERIFICATION_PENDING);

        when(clientRepository.findByClientEmail(email)).thenReturn(Optional.empty());
        when(clientNVerifiedRepository.findByClientEmail(email)).thenReturn(Optional.of(client));

        ClientRegisterResponseDTO response = clientService.clientRegister(ClientRegisterRequestDTO.builder().clientEmail(email).clientName(name).build());

        assertTrue(response.isCodeSent());
        assertEquals(PendingState.VERIFICATION_PENDING, response.getRegisterStatus());
    }

    @Test
    public void shouldFailSendEmailWhenPendingClientInCooldown(){
        String email = "user@example.com";
        String name = "user";
        String phone = "+48123456789";

        ClientNVerifiedEntity client = new ClientNVerifiedEntity();
        client.setClientEmail(email);
        client.setClientName(name);
        client.setClientNumber(phone);
        client.setClientCodeLastSent(OffsetDateTime.now().minusMinutes(1));
        client.setAccountState(PendingState.VERIFICATION_PENDING);

        when(clientRepository.findByClientEmailOrClientNumber(email, phone)).thenReturn(Optional.empty());
        when(clientNVerifiedRepository.findByClientEmailOrClientNumber(email, phone)).thenReturn(Optional.of(client));

        ClientRegisterResponseDTO response = clientService.clientRegister(ClientRegisterRequestDTO.builder().clientEmail(email).clientName(name).clientPhone(phone).build());

        assertFalse(response.isCodeSent());
        assertEquals(PendingState.VERIFICATION_PENDING, response.getRegisterStatus());
    }

    @Test
    public void shouldFailSendEmailWhenPendingClientInPasswordPending() {
        String email = "user@example.com";
        String name = "user";
        String phone = "+48123456789";

        ClientNVerifiedEntity client = new ClientNVerifiedEntity();
        client.setClientEmail(email);
        client.setClientName(name);
        client.setClientNumber(phone);
        client.setClientCodeLastSent(OffsetDateTime.now().minusMinutes(1));
        client.setAccountState(PendingState.PASSWORD_PENDING);

        when(clientRepository.findByClientEmailOrClientNumber(email,phone)).thenReturn(Optional.empty());
        when(clientNVerifiedRepository.findByClientEmailOrClientNumber(email,phone)).thenReturn(Optional.of(client));

        ClientRegisterResponseDTO response = clientService.clientRegister(ClientRegisterRequestDTO.builder().clientEmail(email).clientName(name).clientPhone(phone).build());

        assertFalse(response.isCodeSent());
        assertEquals(PendingState.PASSWORD_PENDING, response.getRegisterStatus());
    }

    @Test
    public void shouldThrowExceptionWhenClientAlreadyExists() {
        String email = "user@example.com";
        String name = "user";
        String phone = "+48123456789";

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientEmail(email);
        clientEntity.setClientName(name);
        clientEntity.setClientNumber(phone);

        when(clientRepository.findByClientEmailOrClientNumber(email,phone)).thenReturn(Optional.of(clientEntity));

        ClientAlreadyExistsException exception = assertThrows(ClientAlreadyExistsException.class, () -> clientService.clientRegister(ClientRegisterRequestDTO.builder().clientEmail(email).clientName(name).clientPhone(phone).build()));

        assertEquals(exception.getCode(), CLIENT_ALREADY_EXISTS_CODE);
    }

    @Test
    public void shouldVerifyIfEverythingSuccessful(){
        String email = "user@example.com";
        String name = "user";
        String code = "654012";
        String phone = "+48123456789";

        ClientNVerifiedEntity client = new ClientNVerifiedEntity();
        client.setClientEmail(email);
        client.setClientName(name);
        client.setClientCodeLastSent(OffsetDateTime.now().minusMinutes(0));
        client.setAccountState(PendingState.VERIFICATION_PENDING);
        client.setClientCode("654012");
        client.setClientNumber(phone);
        client.setClientCodeExpire(OffsetDateTime.now().plusMinutes(15));

        when(clientRepository.findByClientEmail(email)).thenReturn(Optional.empty());
        when(clientNVerifiedRepository.findByClientEmail(email)).thenReturn(Optional.of(client));

        ClientVerificationResponseDTO response = clientService.clientVerify(ClientVerificationRequestDTO.builder().clientEmail(email).verificationCode(code).build());

        assertTrue(response.isVerified());
        assertEquals(PendingState.PASSWORD_PENDING, response.getStatus());
    }

    @Test
    public void shouldFailIfCodeIsWrong(){
        String email = "user@example.com";
        String name = "user";
        String code = "654012";
        String phone = "+48123456789";

        ClientNVerifiedEntity client = new ClientNVerifiedEntity();
        client.setClientEmail(email);
        client.setClientName(name);
        client.setClientCodeLastSent(OffsetDateTime.now().minusMinutes(0));
        client.setAccountState(PendingState.VERIFICATION_PENDING);
        client.setClientCode("654013");
        client.setClientNumber(phone);
        client.setClientCodeExpire(OffsetDateTime.now().plusMinutes(15));

        when(clientRepository.findByClientEmail(email)).thenReturn(Optional.empty());
        when(clientNVerifiedRepository.findByClientEmail(email)).thenReturn(Optional.of(client));

        VerificationFailedException response = assertThrows(VerificationFailedException.class, () -> clientService.clientVerify(ClientVerificationRequestDTO.builder().clientEmail(email).verificationCode(code).build()));

        assertEquals(response.getCode(), VERIFICATION_FAILED_CODE);
    }

    @Test
    public void shouldThrowExceptionIfCodeIsExpired(){
        String email = "user@example.com";
        String name = "user";
        String code = "654013";

        ClientNVerifiedEntity client = new ClientNVerifiedEntity();
        client.setClientEmail(email);
        client.setClientName(name);
        client.setClientCodeLastSent(OffsetDateTime.now().minusMinutes(15));
        client.setAccountState(PendingState.VERIFICATION_PENDING);
        client.setClientCode("654013");
        client.setClientCodeExpire(OffsetDateTime.now().minusMinutes(1));

        when(clientRepository.findByClientEmail(email)).thenReturn(Optional.empty());
        when(clientNVerifiedRepository.findByClientEmail(email)).thenReturn(Optional.of(client));

        VerificationFailedException response = assertThrows(VerificationFailedException.class, () -> clientService.clientVerify(ClientVerificationRequestDTO.builder().clientEmail(email).verificationCode(code).build()));

        assertEquals(response.getCode(), VERIFICATION_FAILED_CODE);
    }

    @Test
    public void shouldThrowExceptionIfStateIsDifferent(){
        String email = "user@example.com";
        String name = "user";
        String code = "654013";

        ClientNVerifiedEntity client = new ClientNVerifiedEntity();
        client.setClientEmail(email);
        client.setClientName(name);
        client.setClientCodeLastSent(OffsetDateTime.now().minusMinutes(15));
        client.setAccountState(PendingState.PASSWORD_PENDING);
        client.setClientCode("654013");
        client.setClientCodeExpire(OffsetDateTime.now().minusMinutes(1));

        when(clientRepository.findByClientEmail(email)).thenReturn(Optional.empty());
        when(clientNVerifiedRepository.findByClientEmail(email)).thenReturn(Optional.of(client));

        VerificationFailedException response = assertThrows(VerificationFailedException.class, () -> clientService.clientVerify(ClientVerificationRequestDTO.builder().clientEmail(email).verificationCode(code).build()));

        assertEquals(response.getCode(), VERIFICATION_FAILED_CODE);
    }

    @Test
    void shouldCreateClientIfEverythingSuccessful(){
        String email = "user@example.com";
        String password = "userpassword";
        String phone = "+48123456789";

        ClientNVerifiedEntity client = new ClientNVerifiedEntity();
        client.setClientEmail(email);
        client.setClientCodeLastSent(OffsetDateTime.now().minusMinutes(15));
        client.setAccountState(PendingState.PASSWORD_PENDING);
        client.setClientCode("654013");
        client.setClientNumber(phone);
        client.setClientCodeExpire(OffsetDateTime.now().minusMinutes(1));

        when(clientRepository.findByClientEmail(email)).thenReturn(Optional.empty());
        when(clientNVerifiedRepository.findByClientEmail(email)).thenReturn(Optional.of(client));

        ClientPasswordCreationResponseDTO response = clientService.clientCreation(ClientPasswordCreationRequestDTO.builder().clientEmail(email).clientPassword(password).build());

        assertTrue(response.isProfileCreated());
        verify(clientRepository).save(any(ClientEntity.class));
        verify(clientNVerifiedRepository).delete(client);
    }

    @Test
    void shouldThrowExceptionWhenClientNotFound() {
        String email = "user@example.com";
        String password = "userpassword";

        when(clientNVerifiedRepository.findByClientEmail(email)).thenReturn(Optional.empty());

        ClientNotFoundException exception = assertThrows(ClientNotFoundException.class, () -> clientService.clientCreation(ClientPasswordCreationRequestDTO.builder().clientEmail(email).clientPassword(password).build()));

        assertEquals(exception.getCode(), CLIENT_NOT_FOUND_CODE);
    }

    @Test
    void shouldThrowExceptionWhenStateIsDifferent() {
        String email = "user@example.com";
        String password = "userpassword";

        ClientNVerifiedEntity client = new ClientNVerifiedEntity();
        client.setClientEmail(email);
        client.setClientCodeLastSent(OffsetDateTime.now().minusMinutes(15));
        client.setAccountState(PendingState.NEW_USER);
        client.setClientCode("654013");
        client.setClientCodeExpire(OffsetDateTime.now().minusMinutes(1));

        when(clientNVerifiedRepository.findByClientEmail(email)).thenReturn(Optional.of(client));

        VerificationFailedException exception = assertThrows(VerificationFailedException.class, () -> clientService.clientCreation(ClientPasswordCreationRequestDTO.builder().clientEmail(email).clientPassword(password).build()));

        assertEquals(exception.getCode(), VERIFICATION_FAILED_CODE);
    }
}
