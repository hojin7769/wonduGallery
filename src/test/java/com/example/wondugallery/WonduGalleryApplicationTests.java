package com.example.wondugallery;

import com.example.wondugallery.config.JasyptConfig;
import jakarta.annotation.Resource;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class WonduGalleryApplicationTests {
    @Resource(name = "jasyptStringEncryptor")
    private StringEncryptor stringEncryptor;

    @Test
    void contextLoads() {
        GetEncryptInfo();
    }


    public void GetEncryptInfo() {
        // jwt.key
        String key_enc = stringEncryptor.encrypt("#BumYang@ERP!#");
        System.out.println("key = ENC(" + key_enc + ")");

        // id
        String id_enc = stringEncryptor.encrypt("");
        System.out.println("id = ENC(" + id_enc + ")");

        // pw
        String pw_enc = stringEncryptor.encrypt("");
        System.out.println("pw = ENC(" + pw_enc + ")");

        // 테스트용 복호화
        String id_des = stringEncryptor.decrypt(id_enc);
        String pw_des = stringEncryptor.decrypt(pw_enc);
        System.out.println("id = " + id_des + ", pw = " + pw_des);
    }
}
