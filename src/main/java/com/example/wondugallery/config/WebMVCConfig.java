package com.example.wondugallery.config;

import com.example.wondugallery.config.filter.interceptor.WebLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author admin
 * @version 1.0
 * @project wondu-gallery
 * @package com.example.wondugallery.config
 * @date 2023-10-06
 * @explanation
 */
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    static final String RESOURCE_PATTEN = "/**";
    static final String RESOURCE_LOCATION = "classpath:/static/";
//    private final CurrentUsernameResolver currentUsernameResolver;


//    @Autowired
//    public WebMVCConfig(CurrentUsernameResolver currentUsernameResolver) {
//        this.currentUsernameResolver = currentUsernameResolver;
//    }

//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(currentUsernameResolver);
//    }

    @Override
    public void addInterceptors( InterceptorRegistry registry ) {

        registry.addInterceptor( new WebLoggingInterceptor() );
    }
}
