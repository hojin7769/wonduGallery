package com.example.wondugallery.filterUtils.filter;

import com.example.wondugallery.utils.MDCUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Enumeration<String> str = req.getHeaderNames();

        try {
            MDCUtils.put( "requestUID" , "test");
            MDCUtils.put( "requestUserAgent" , req.getHeaderNames().toString() );

            chain.doFilter( request, response );
        }
        finally {
            MDCUtils.clear();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }

    private String getHeader( HttpServletRequest req ) {
        return req.getHeader( "X-Forwarded-For" );
    }
}
