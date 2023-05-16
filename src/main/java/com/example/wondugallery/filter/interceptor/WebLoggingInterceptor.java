//package com.example.wondugallery.filter.interceptor;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//public class WebLoggingInterceptor implements HandlerInterceptor {
//
//    Logger requestLog = LoggerFactory.getLogger( "REQUEST_lOG" );
//
//    @Override
//    public boolean preHandle(
//            HttpServletRequest request, HttpServletResponse response,
//            Object obj) throws Exception {
//
//        requestLog.info( "" );
//
//        return true;
//    }
//}
