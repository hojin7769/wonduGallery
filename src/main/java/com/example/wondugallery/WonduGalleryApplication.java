package com.example.wondugallery;

import com.example.wondugallery.config.WonduGalleryBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ConfigurationPropertiesScan
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.wondugallery")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WonduGalleryApplication {

    public static void main(String[] args) {
        String profile = System.getProperty( "spring.profiles.active" , "local" );
        String envPath = System.getProperty( "spring.config.location", "classpath:application-" + profile + ".yml" );

        System.setProperty( "spring.profiles.active" , profile );
        System.setProperty( "spring.config.location" , envPath );

        SpringApplication sp = new SpringApplication( WonduGalleryApplication.class );
        sp.setBanner( new WonduGalleryBanner() );
        sp.run( args );
    }

}
