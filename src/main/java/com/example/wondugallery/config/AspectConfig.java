package com.example.wondugallery.config;

import com.example.wondugallery.config.filter.aspect.APILoggingAspect;
import com.example.wondugallery.config.filter.aspect.ServiceLoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @version 1.0
 * @project wondu-gallery
 * @package com.example.wondugallery.config
 * @date 2023-10-06
 * @explanation
 */
@Configuration
public class AspectConfig {

    /**
     * API LOG
     * */
    @Bean
    public APILoggingAspect apiLoggingAspect () {
        return new APILoggingAspect();
    }
    @Bean
    public ServiceLoggingAspect serviceLoggingAspect () {
        return new ServiceLoggingAspect();
    }
}
