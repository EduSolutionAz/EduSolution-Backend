package com.edu.edusolution.dto.request;

import com.edu.edusolution.entity.university.UniversityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddUniversityRequestDTO {

    private String universityName;
    private String countryName;
    private UniversityType universityType;
    private String shortDescription;
    private MultipartFile universityLogo;
    private String city;

    private String content;
    private String area;
}
