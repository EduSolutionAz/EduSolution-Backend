package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.AdminLogRequestDTO;
import com.edu.edusolution.dto.request.AdminRegisterRequestDTO;
import com.edu.edusolution.dto.response.AdminLogResponse;
import com.edu.edusolution.dto.response.AdminRegisterResponseDTO;
import com.edu.edusolution.entity.admin.AdminEntity;
import com.edu.edusolution.exception.AdminCreationException;
import com.edu.edusolution.exception.AdminNotFoundException;
import com.edu.edusolution.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

import static com.edu.edusolution.constants.ExceptionConstants.*;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminLogResponse authenticate(AdminLogRequestDTO request) {

        AdminEntity user = adminRepository.findByAdminUsername(request.getUsername())
                .orElseThrow(() -> new AdminNotFoundException(ADMIN_NOT_FOUND_MSG));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String jwtToken = jwtService.generateToken(user);

        return AdminLogResponse
                .builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();
    }

    public AdminRegisterResponseDTO adminRegister(AdminRegisterRequestDTO request) {
        Optional<AdminEntity> user = adminRepository.findByAdminUsername(request.getUsername());

        if(user.isPresent()){
            throw new AdminCreationException();
        }

        AdminEntity admin = new AdminEntity();
        admin.setAdminEmail(request.getEmail());
        admin.setAdminPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        admin.setAdminUsername(request.getUsername());
        adminRepository.save(admin);

        return AdminRegisterResponseDTO
                .builder()
                .isRegistered(true)
                .build();
    }

}
