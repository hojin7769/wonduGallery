package com.example.wondugallery.utils;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.wondugallery.config.S3Config;
import com.example.wondugallery.service.S3.dto.S3FileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@RequiredArgsConstructor
@Component
public class FileUploader {

    @Value("${cloud.aws.s3.bucket}")
    private String BURKETNAME;

    private final AmazonS3Client amazonS3Client;


    public List<S3FileDto> uploadFiles(Long boardSeq, List<MultipartFile> multipartFiles){

        List<S3FileDto> s3files = new ArrayList<>();

        String uploadFilePath = boardSeq + "/" + getFolderName();

        for (MultipartFile multipartFile : multipartFiles){
            String originalFileName = multipartFile.getOriginalFilename();
            String uploadFileName = getUuidFileName(originalFileName);
            String uploadFileUrl = "";

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(multipartFile.getSize());
            objectMetadata.setContentType(multipartFile.getContentType());
            try (InputStream inputStream = multipartFile.getInputStream()) {
                String keyName = uploadFilePath + "/" + uploadFileName; // ex) 구분/년/월/일/파일.확장자
                amazonS3Client.putObject(
                        new PutObjectRequest(BURKETNAME, keyName, inputStream, objectMetadata));

                uploadFileUrl = amazonS3Client.getUrl(BURKETNAME, keyName).toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            s3files.add(
                    S3FileDto.builder()

                            .originalFileName(originalFileName)
                            .uploadFileName(uploadFileName)
                            .uploadFilePath(uploadFilePath)
                            .uploadFileUrl(uploadFileUrl)
                            .build());
        }
        return s3files;
    }


    /**
     * UUID 파일명 반환
     */
    public String getUuidFileName(String fileName) {
        int i = fileName.lastIndexOf(".");
        String ext = fileName.substring(i + 1);
        return UUID.randomUUID().toString() + "." + ext;
    }



    private String getFolderName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        String str = sdf.format(date);
        return str.replace("-", "/");
    }

}
