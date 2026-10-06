package com.edu.edusolution.dto.request.ad;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdAddRequestDTO {
    @Size(max = 75, message = "Title can be max 75 chars")
    @NotBlank
    @NotNull
    private String title;

    @NotNull
    @NotBlank
    private String content;
    private MultipartFile image;
}
