package com.example.wondugallery.filterUtils.filter;

import com.example.wondugallery.utils.MDCUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

@Slf4j
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
            MDCUtils.put( "requestUID" , UUID.randomUUID().toString().substring(0,8));
//            MDCUtils.put( "requestUserAgent" , req.getHeaderNames().toString() );

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

}
