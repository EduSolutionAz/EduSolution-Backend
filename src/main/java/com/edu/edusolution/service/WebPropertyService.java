package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.AddWebPropertiesRequestDTO;
import com.edu.edusolution.dto.response.AddWebPropertiesResponseDTO;
import com.edu.edusolution.dto.response.WebPropertiesResponseDTO;
import com.edu.edusolution.entity.web.WebPropertyEntity;
import com.edu.edusolution.exception.WebPropertyArgumentException;
import com.edu.edusolution.exception.WebPropertyNotFoundException;
import com.edu.edusolution.repository.WebPropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.edu.edusolution.constants.ExceptionConstants.WEB_PROPERTY_ILLEGAL_ARGUMENT_ADMISSION_MSG;
import static com.edu.edusolution.constants.ExceptionConstants.WEB_PROPERTY_ILLEGAL_ARGUMENT_VISA_MSG;

@Service
@RequiredArgsConstructor
public class WebPropertyService {

    private final WebPropertyRepository webPropertyRepository;

    public WebPropertiesResponseDTO getProperties() {

        WebPropertyEntity entity = webPropertyRepository.findFirstByOrderByCreatedAtDesc()
                .orElseThrow(WebPropertyNotFoundException::new);

        WebPropertiesResponseDTO response = new WebPropertiesResponseDTO();
        response.setAdmissionSent(entity.getAdmissionSent());
        response.setStudentHelped(entity.getStudentHelped());
        response.setSuccessfulAdmission(entity.getSuccessfulAdmission());
        response.setVisaHelp(entity.getVisaHelp());
        response.setVisaSuccessRate(entity.getVisaSuccessRate());
        response.setSuccessfulVisaHelp(entity.getSuccessfulVisaHelp());

        return response;
    }

    public AddWebPropertiesResponseDTO addProperty(AddWebPropertiesRequestDTO request) {

        if(request.getAdmissionsSent() < request.getSuccessfulAdmissions()){
            throw new WebPropertyArgumentException(WEB_PROPERTY_ILLEGAL_ARGUMENT_ADMISSION_MSG);
        } else if (request.getVisaHelp() < request.getSuccessfulVisaHelp()) {
            throw new WebPropertyArgumentException(WEB_PROPERTY_ILLEGAL_ARGUMENT_VISA_MSG);
        }

        WebPropertyEntity web = new WebPropertyEntity();
        web.setAdmissionSent(request.getAdmissionsSent());
        web.setStudentHelped(request.getStudentsHelped());
        web.setVisaHelp(request.getVisaHelp());
        web.setSuccessfulAdmission(request.getSuccessfulAdmissions());
        web.setSuccessfulVisaHelp(request.getSuccessfulVisaHelp());
        web.setVisaSuccessRate(calculateVisaRate(request.getVisaHelp(), request.getSuccessfulVisaHelp()));

        webPropertyRepository.save(web);

        return AddWebPropertiesResponseDTO
                .builder()
                .isCreated(true)
                .build();
    }

    private BigDecimal calculateVisaRate(int visaAdmission, int successfulAdmission) {

        double rate = (double) (successfulAdmission * 100) / visaAdmission;

        return new BigDecimal(rate).setScale(2, RoundingMode.UNNECESSARY);
    }
}
