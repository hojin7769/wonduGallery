package com.example.wondugallery.config;

import com.example.wondugallery.config.filter.log.LogFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
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
public class FilterConfig {
    /**
     * LogFilter Bean
     * 모든 URL에 적용
     * */
    @Bean
    public FilterRegistrationBean<Filter> logFilter() {

        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LogFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        registrationBean.setName("LogFilter");
        return registrationBean;
    }
}
