package com.edu.edusolution.controller;

import com.edu.edusolution.dto.request.ad.AdAddRequestDTO;
import com.edu.edusolution.dto.response.ad.*;
import com.edu.edusolution.service.AdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ad")
@RequiredArgsConstructor
@Tag(name = "Ad Operations", description = "This is for ad operations in website")
public class AdController {
    private final AdService adService;

    @PostMapping("/add")
    public ResponseEntity<AdAddResponseDTO> addAd(@ModelAttribute AdAddRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adService.addAd(request));
    }

    @GetMapping("/info/{adTitle}")
    public ResponseEntity<AdInformationResponseDTO> adInformation(@PathVariable String adTitle) {
        return ResponseEntity.ok(adService.getAdInformation(adTitle));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdsResponseDTO>> getAds() {
        return ResponseEntity.ok(adService.getAds());
    }

    @DeleteMapping("/delete/{adTitle}")
    public ResponseEntity<DeleteAdResponseDTO> deleteAd(@PathVariable String adTitle) {
        return ResponseEntity.ok(adService.deleteAd(adTitle));
    }

    @PatchMapping("/update")
    public ResponseEntity<UpdateAdResponseDTO> updateAd(@ModelAttribute AdAddRequestDTO request) {
        return ResponseEntity.ok(adService.updateAdd(request));
    }
}
