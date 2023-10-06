package com.example.wondugallery.config.filter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author admin
 * @version 1.0
 * @project wondu-gallery
 * @package com.example.wondugallery.config.filter.interceptor
 * @date 2023-10-06
 * @explanation
 */
public class WebLoggingInterceptor implements HandlerInterceptor{
    Logger requestLog = LoggerFactory.getLogger("REQUEST_LOG");

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object obj) throws Exception {

        //requestLog.info( "" );

        return true;
    }
}
