package com.edu.edusolution.config;

import com.edu.edusolution.entity.admin.AdminEntity;
import com.edu.edusolution.exception.EmailException;
import com.edu.edusolution.repository.AdminRepository;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.domains.model.CreateDomainOptions;
import com.resend.services.domains.model.CreateDomainResponse;
import com.resend.services.domains.model.Domain;
import com.resend.services.emails.model.CreateEmailResponse;
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
    @Value("${resend.api.domain_code}")
    private String domainCode;
    @Value("${resend.api.key}")
    private String resendApi;

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

    @Bean
    CommandLineRunner createInitialEmailProvider() {
        Resend resend = new Resend(resendApi);
        return args -> {
            try {
                Domain domain = resend.domains().get(domainCode);
            } catch (ResendException ex){
                throw new EmailException();
            }
        };
    }
}
