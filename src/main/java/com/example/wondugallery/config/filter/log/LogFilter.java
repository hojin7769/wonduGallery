package com.example.wondugallery.config.filter.log;

import com.example.wondugallery.utils.MDCUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @author admin
 * @version 1.0
 * @project wondu-gallery
 * @package com.example.wondugallery.config.filter.log
 * @date 2023-10-06
 * @explanation
 */
public class LogFilter implements Filter {
    /**
     * 필터가 생성될 때 수행되는 메소드
     *
     * @param filterConfig - filterConfig
     * @throws ServletException
     * */
    @Override
    public void init ( FilterConfig filterConfig ) throws ServletException {

    }

    /**
     * Request, Response가 필터를 거칠 때 수행되는 메소드
     * LogFilter에서는 Request 정보로 MDC 정보를 생성하기 위해서 사용
     *
     * @param request - 사용자 요청 정보
     * @param response - 응답 정보
     * @param chain - chain
     * */
    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain )
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        Enumeration<String> str = req.getHeaderNames();

        try {
            MDCUtils.put( "requestUID" , RandomStringUtils.randomAlphanumeric( 8 ) );
            MDCUtils.put("requestUserAgent" , req.getHeaderNames().toString());

            chain.doFilter( request, response );
        }
        finally {
            MDCUtils.clear();
        }
    }

    /**
     * 필터 소멸시 호출
     * */
    @Override
    public void destroy () {

    }

    private String getHeader( HttpServletRequest req ) {

        return req.getHeader( "X-Forwarded-For" );
    }
}
