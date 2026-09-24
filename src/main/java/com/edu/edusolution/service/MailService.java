package com.edu.edusolution.service;

import com.edu.edusolution.exception.EmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.resend.*;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;

@Service
@RequiredArgsConstructor
public class MailService {

    @Value("${resend.api.key}")
    private String resendApiKey;

    public void sendPlainText(String to, String subject, String body){
        Resend resend = new Resend(resendApiKey);

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("onboarding@resend.dev")
                .to(to)
                .subject(subject)
                .html(body)
                .build();

        try {
            CreateEmailResponse data = resend.emails().send(params);
        } catch (ResendException ex){
            throw new EmailException();
        }


    }
}
