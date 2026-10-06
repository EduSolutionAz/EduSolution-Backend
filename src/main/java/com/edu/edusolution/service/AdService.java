package com.edu.edusolution.service;

import com.edu.edusolution.dto.request.ad.AdAddRequestDTO;
import com.edu.edusolution.dto.response.ad.*;
import com.edu.edusolution.entity.ad.AdEntity;
import com.edu.edusolution.exception.*;
import com.edu.edusolution.repository.AdRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.edu.edusolution.constants.ExceptionConstants.DATA_DELETE_S3_AD_MSG;
import static com.edu.edusolution.constants.S3Constants.*;
import static com.edu.edusolution.constants.S3Constants.S3_BUCKET_NAME;

@Service
@RequiredArgsConstructor
public class AdService {

    private final AdRepository adRepository;
    private final S3Client s3Client;

    @Transactional
    public AdAddResponseDTO addAd(AdAddRequestDTO request) {

        String title = request.getTitle().trim().toLowerCase().replace(' ','_').replace('-','_').replace('.','_').replace(',','_');

        Optional<AdEntity> ad = adRepository.findByTitleIgnoreCase(title);

        if(ad.isPresent()) {
            throw new AdAlreadyExistsException();
        }

        PutObjectRequest flagRequest = PutObjectRequest
                .builder()
                .bucket(S3_BUCKET_NAME)
                .key(AD_FOLDER_KEY+title+AD_LOGO_KEY)
                .contentType(request.getImage().getContentType())
                .build();

        try {
            s3Client.putObject(
                    flagRequest,
                    RequestBody.fromInputStream(
                            request.getImage().getInputStream(),
                            request.getImage().getSize()
                    )
            );

        } catch (S3Exception | IOException ex) {
            throw new AdUploadException();
        }

        AdEntity newAd = new AdEntity();
        newAd.setContent(request.getContent());
        newAd.setTitle(title);
        newAd.setAdUrl(S3_PUBLIC_SHARE_LINK+AD_FOLDER_KEY+title+AD_LOGO_KEY);
        newAd.setTitleNotChanged(request.getTitle());

        adRepository.save(newAd);

        return AdAddResponseDTO
                .builder()
                .title(request.getTitle())
                .isCreated(true)
                .build();
    }

    public AdInformationResponseDTO getAdInformation(String adTitle) {
        String title = adTitle.trim().toLowerCase().replace(' ','_').replace('-','_').replace('.','_').replace(',','_');

        Optional<AdEntity> checkAd = adRepository.findByTitleIgnoreCase(title);

        if(checkAd.isEmpty()){
            throw new AdNotFoundException();
        }

        return AdInformationResponseDTO
                .builder()
                .content(checkAd.get().getContent())
                .photoUrl(checkAd.get().getAdUrl())
                .title(checkAd.get().getTitleNotChanged())
                .build();

    }

    public List<AdsResponseDTO> getAds(){
        List<AdEntity> topAds = adRepository.findAll();

        return topAds
                .stream()
                .map
                        (
                                adEntity ->
                                        new AdsResponseDTO(adEntity.getTitle(), adEntity.getAdUrl())
                        )
                .toList();
    }

    @Transactional
    public DeleteAdResponseDTO deleteAd(String adTitle){
        String title = adTitle.trim().toLowerCase().replace(' ','_').replace('-','_').replace('.','_').replace(',','_');

        Optional<AdEntity> checkAd = adRepository.findByTitleIgnoreCase(title);

        if(checkAd.isEmpty()){
            throw new AdNotFoundException();
        }

        DeleteObjectRequest deleteObjectRequest =
                DeleteObjectRequest
                        .builder()
                        .bucket(S3_BUCKET_NAME)
                        .key(AD_FOLDER_KEY+title+AD_LOGO_KEY)
                        .build();


        try {
            s3Client.deleteObject(deleteObjectRequest);
        } catch (S3Exception ex){
            throw new DataDeleteException(DATA_DELETE_S3_AD_MSG);
        }

        adRepository.delete(checkAd.get());

        return DeleteAdResponseDTO
                .builder()
                .title(adTitle)
                .isDeleted(true)
                .build();
    }

    @Transactional
    public UpdateAdResponseDTO updateAdd(AdAddRequestDTO request){
        String title = request.getTitle().trim().toLowerCase().replace(' ','_').replace('-','_').replace('.','_').replace(',','_');

        Optional<AdEntity> checkAd = adRepository.findByTitleIgnoreCase(title);

        if(checkAd.isEmpty()){
            throw new AdNotFoundException();
        }

        checkAd.get().setContent(request.getContent());

        DeleteObjectRequest deleteObjectRequest =
                DeleteObjectRequest
                        .builder()
                        .bucket(S3_BUCKET_NAME)
                        .key(AD_FOLDER_KEY+title+AD_LOGO_KEY)
                        .build();


        try {
            s3Client.deleteObject(deleteObjectRequest);
        } catch (S3Exception ex){
            throw new DataDeleteException(DATA_DELETE_S3_AD_MSG);
        }

        PutObjectRequest viewRequest = PutObjectRequest
                .builder()
                .bucket(S3_BUCKET_NAME)
                .key(AD_FOLDER_KEY+title+AD_LOGO_KEY)
                .contentType(request.getImage().getContentType())
                .build();

        try {
            s3Client.putObject(
                    viewRequest,
                    RequestBody.fromInputStream(
                            request.getImage().getInputStream(),
                            request.getImage().getSize()
                    )
            );

        } catch (S3Exception | IOException ex) {
            throw new CountryUploadException();
        }

        adRepository.save(checkAd.get());

        return UpdateAdResponseDTO
                .builder()
                .build();
    }
}
