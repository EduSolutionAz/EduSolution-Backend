package com.edu.edusolution.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryAddRequestDTO {
    private String countryName;
    private MultipartFile flagImage;
    private MultipartFile countryImage;
    private int universityCount;
    private BigDecimal tuitionFee;
    private BigDecimal rentalFee;
    private boolean isVisaHelp;
    private boolean isDormitoryHelp;
    private String content;
    private String area;

}
