package com.example.wondugallery.filterUtils.config;

import com.example.wondugallery.filterUtils.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<LogFilter> logFilter() {

        FilterRegistrationBean<LogFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter( new LogFilter() );
        registrationBean.addUrlPatterns( "/*" );
        registrationBean.setOrder( 1 );
        registrationBean.setName( "LogFilter" );
        return registrationBean;
    }
}
