package com.example.wondugallery.config;

import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.test.context.ActiveProfiles;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;

import java.io.File;

@SpringBootTest
@ActiveProfiles("local")
@Import(JasyptConfig.class)
public class S3IntegrationTest {

    @Autowired
    private AmazonS3Client s3Client;

    @Test
    void testS3Access(){
        // 예시: 버킷 생성
//        String bucketName = "test-my-bucket-hojin-test";
//        s3Client.createBucket(bucketName);

        // 예시: 파일 업로드
        String objectKey = "my-file.txt";
        String content = "Hello, S3!";
        s3Client.putObject("wondu-file-storge",objectKey, String.valueOf(RequestBody.fromString(content)));





    }

}
