package com.edu.edusolution.config;

import com.edu.edusolution.entity.admin.AdminEntity;
import com.edu.edusolution.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminConfig {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.cred.username}")
    private String username;
    @Value("${admin.cred.password}")
    private String password;
    @Value("${admin.cred.email}")
    private String email;

    @Bean
    CommandLineRunner createInitialAdmin() {
        return args -> {
            if (adminRepository.count() == 0) {
                AdminEntity admin = new AdminEntity();

                admin.setAdminUsername(username);
                admin.setAdminEmail(email);
                admin.setAdminPassword(
                        passwordEncoder.encode(password)
                );

                adminRepository.save(admin);
            }
        };
    }
}
