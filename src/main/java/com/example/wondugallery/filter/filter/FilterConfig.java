//package com.example.wondugallery.filter.filter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 필터 Bean 등록
// *
// * @author ted
// * @version 2023.03.34
// * */
//
//public class FilterConfig {
//
//    /**
//     * LogFilter Bean
//     * 모든 URL에 적용
//     * */
//    @Bean
//    public FilterRegistrationBean<LogFilter> logFilter() {
//
//        FilterRegistrationBean<LogFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter( new LogFilter() );
//        registrationBean.addUrlPatterns( "/*" );
//        registrationBean.setOrder( 1 );
//        registrationBean.setName( "LogFilter" );
//        return registrationBean;
//    }
//}
