package com.example.wondugallery.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author admin
 * @version 1.0
 * @project wondu-gallery
 * @package com.example.wondugallery.config
 * @date 2023-10-23
 * @explanation
 */
@TestConfiguration
public class JasyptTest {
    @Value("${jasypt.encryptor.password}")
    private String password;
    @Value("${jasypt.encryptor.algorithm}")
    private String algorithm;

    @Bean
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setAlgorithm(algorithm);
        config.setPassword(password);
        config.setPoolSize(1);
        encryptor.setConfig(config);

        return encryptor;
    }
}
