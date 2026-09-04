package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.ClientPasswordCreationRequestDTO;
import com.edu.edusolution.dto.request.ClientRegisterRequestDTO;
import com.edu.edusolution.dto.request.ClientVerificationRequestDTO;
import com.edu.edusolution.dto.response.ClientPasswordCreationResponseDTO;
import com.edu.edusolution.dto.response.ClientRegisterResponseDTO;
import com.edu.edusolution.dto.response.ClientVerificationResponseDTO;
import com.edu.edusolution.entity.client.ClientEntity;
import com.edu.edusolution.entity.client.ClientNVerifiedEntity;
import com.edu.edusolution.entity.client.ClientRoles;
import com.edu.edusolution.entity.client.PendingState;
import com.edu.edusolution.exception.ClientAlreadyExistsException;
import com.edu.edusolution.exception.ClientNotFoundException;
import com.edu.edusolution.exception.VerificationFailedException;
import com.edu.edusolution.repository.ClientNVerifiedRepository;
import com.edu.edusolution.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.Random;

import static com.edu.edusolution.constants.ExceptionConstants.*;
import static com.edu.edusolution.constants.RegisterConstants.REGISTER_SUBJECT;
import static com.edu.edusolution.constants.RegisterConstants.VERIFICATION_CODE_LENGTH;


@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientNVerifiedRepository clientNVerifiedRepository;
    private final MailService mailService;

    public ClientRegisterResponseDTO clientRegister (ClientRegisterRequestDTO request) {
        Optional<ClientEntity> clientEntity = clientRepository.findByClientEmail(request.getClientEmail());

        if(clientEntity.isPresent()){
            throw new ClientAlreadyExistsException(CLIENT_ALREADY_EXISTS_EMAIL_MSG);
        }

        Optional<ClientNVerifiedEntity> checkClient= clientNVerifiedRepository.findByClientEmailAndClientNumber(request.getClientEmail(), request.getClientPhone());
        System.out.println("NOW clientNV");
        ClientNVerifiedEntity clientNV = getClientNVEntity(checkClient, request.getClientEmail(), request.getClientName(), request.getClientPhone());
        System.out.println("Passed clientNV");
        boolean isEligibleForEmail = checkEligibilityForVerificationEmail(clientNV);
        System.out.println("Mail Sending");
        if(!isEligibleForEmail){
            return ClientRegisterResponseDTO
                    .builder()
                    .clientEmail(clientNV.getClientEmail())
                    .registerStatus(clientNV.getAccountState())
                    .codeSent(false)
                    .build();
        }

        return sendVerificationEmail(clientNV);
    }

    public ClientVerificationResponseDTO clientVerify (ClientVerificationRequestDTO request) {

        Optional<ClientEntity> clientEntity = clientRepository.findByClientEmail(request.getClientEmail());

        if(clientEntity.isPresent()){
            throw new ClientAlreadyExistsException(CLIENT_ALREADY_EXISTS_EMAIL_MSG);
        }

        Optional<ClientNVerifiedEntity> checkClient= clientNVerifiedRepository.findByClientEmail(request.getClientEmail());

        if(checkClient.isEmpty()){
            throw new ClientNotFoundException(CLIENT_NOT_FOUND_CODE);
        }

        checkVerificationCode(checkClient.get(), request.getVerificationCode());

        return returnVerificationResponse(checkClient.get());
    }

    @Transactional
    public ClientPasswordCreationResponseDTO clientCreation(ClientPasswordCreationRequestDTO request) {
        Optional<ClientEntity> clientEntity = clientRepository.findByClientEmail(request.getClientEmail());

        if(clientEntity.isPresent()){
            throw new ClientAlreadyExistsException(CLIENT_ALREADY_EXISTS_EMAIL_MSG);
        }

        ClientNVerifiedEntity checkClient= clientNVerifiedRepository.findByClientEmail(request.getClientEmail())
                .orElseThrow(() -> new ClientNotFoundException(CLIENT_NOT_FOUND_MSG));

        if (!checkClient.getAccountState().equals(PendingState.PASSWORD_PENDING)) {
            throw new VerificationFailedException();
        }
        System.out.println(request.getClientPassword());
        ClientEntity client = new ClientEntity();
        client.setClientRoles(ClientRoles.USER);
        client.setClientName(checkClient.getClientName());
        client.setClientEmail(checkClient.getClientEmail());
        client.setClientNumber(checkClient.getClientNumber());
        client.setClientPassword(passwordCreator(request.getClientPassword()));

        clientRepository.save(client);
        clientNVerifiedRepository.delete(checkClient);

        return ClientPasswordCreationResponseDTO
                .builder()
                .isProfileCreated(true)
                .clientEmail(request.getClientEmail())
                .build();
    }

    /* Private Methods that will help us to focus on business logic in public methods */

    private ClientNVerifiedEntity getClientNVEntity(Optional<ClientNVerifiedEntity> clientNVerified, String email, String name, String number){
        return clientNVerified.orElseGet(() -> ClientNVerifiedEntity
                .builder()
                .clientEmail(email)
                .clientName(name)
                .clientNumber(number)
                .accountState(PendingState.NEW_USER)
                .build());
    }

    private boolean isAccountInCooldown(ClientNVerifiedEntity clientNVerified){
        if(clientNVerified.getClientCodeLastSent() == null){
            return false;
        }
        return !clientNVerified.getClientCodeLastSent().isBefore(OffsetDateTime.now().minusMinutes(2));
    }

    private boolean checkEligibilityForVerificationEmail(ClientNVerifiedEntity clientNV){
        return !isAccountInCooldown(clientNV)
                &&
                (
                        clientNV.getAccountState().equals(PendingState.NEW_USER)
                        ||
                        clientNV.getAccountState().equals(PendingState.VERIFICATION_PENDING)
                );
    }

    private ClientRegisterResponseDTO sendVerificationEmail(ClientNVerifiedEntity client){

            String verificationCode = verificationCodeGenerator();
            String message = registerMessage(client.getClientName(), verificationCode);

            client.setClientCode(verificationCode);
            client.setClientCodeLastSent(OffsetDateTime.now());
            client.setClientCodeExpire(OffsetDateTime.now().plusMinutes(15));
            client.setAccountState(PendingState.VERIFICATION_PENDING);

            clientNVerifiedRepository.save(client);

            mailService.sendPlainText(client.getClientEmail(), REGISTER_SUBJECT, message);

            return ClientRegisterResponseDTO
                    .builder()
                    .registerStatus(PendingState.VERIFICATION_PENDING)
                    .codeSent(true)
                    .clientEmail(client.getClientEmail())
                    .build();

    }

    private String registerMessage(String username, String verificationCode){
        return  "Dear "+username
                + "\n"
                + "Thank you for registering our platform"
                + "\n"
                + "Your verification code is : "+verificationCode
                + "\n"
                + "This Code will expire in 15 minutes";
    }
    private String verificationCodeGenerator(){
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i<VERIFICATION_CODE_LENGTH; i++){
            code.append(random.nextInt(0,9));
        }
        return code.toString();
    }

    private void checkVerificationCode(ClientNVerifiedEntity checkClient, String code){
        if
        (
                checkClient.getClientCode().equals(code)
                &&
                checkClient.getClientCodeExpire().isAfter(OffsetDateTime.now())
                &&
                checkClient.getAccountState().equals(PendingState.VERIFICATION_PENDING)
        ) {
            checkClient.setAccountState(PendingState.PASSWORD_PENDING);
            clientNVerifiedRepository.save(checkClient);
        } else {
            throw new VerificationFailedException();
        }
    }

    private ClientVerificationResponseDTO returnVerificationResponse(ClientNVerifiedEntity checkClient) {
        PendingState state = checkClient.getAccountState();

        if (state.equals(PendingState.PASSWORD_PENDING)){
            return  ClientVerificationResponseDTO
                    .builder()
                    .isVerified(true)
                    .clientEmail(checkClient.getClientEmail())
                    .status(state)
                    .build();
        } else {
            return ClientVerificationResponseDTO
                    .builder()
                    .isVerified(false)
                    .status(state)
                    .clientEmail(checkClient.getClientEmail())
                    .build();
        }
    }

    private String passwordCreator(String raw){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        return encoder.encode(raw);

    }
}