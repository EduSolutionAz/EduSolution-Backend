package com.edu.edusolution.service;

import com.edu.edusolution.exception.EmailException;
import com.resend.services.domains.model.CreateDomainOptions;
import com.resend.services.domains.model.CreateDomainResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.resend.*;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {

    @Value("${resend.api.key}")
    private String resendApiKey;

    @Value("${resend.api.domain}")
    private String domain;

    @Value("${resend.email}")
    private String email;

    public void sendPlainText(String to, String subject, String body){
        Resend resend = new Resend(resendApiKey);

        CreateDomainOptions domainParams = CreateDomainOptions
                .builder()
                .name(domain).build();

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from(email)
                .to(to)
                .subject(subject)
                .html(body)
                .build();
        try {
            CreateEmailResponse data = resend.emails().send(params);
            CreateDomainResponse domain = resend.domains().create(domainParams);
        } catch (ResendException ex){
            log.error(ex.getMessage());
            throw new EmailException();
        }


    }
}
