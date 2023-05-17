package com.example.wondugallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WonduGalleryApplication {

    public static void main(String[] args) {
        SpringApplication.run(WonduGalleryApplication.class, args);
    }

}
