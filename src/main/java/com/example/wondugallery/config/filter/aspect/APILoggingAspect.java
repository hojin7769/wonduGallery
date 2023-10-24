package com.example.wondugallery.config.filter.aspect;

import com.example.wondugallery.utils.MDCUtils;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @version 1.0
 * @project wondu-gallery
 * @package com.example.wondugallery.config.filter.aspect
 * @date 2023-10-06
 * @explanation
 */
@Aspect
public class APILoggingAspect {
    private static final Logger apiLog = LoggerFactory.getLogger("API_LOG");

    @Around( value = "execution(* *..*Controller.*(..))")
    public Object onExecutionAPI ( ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {

        long lStartTime = System.currentTimeMillis();
        Object result = null;
        boolean isSuccess = false;
        Gson gson = new Gson();
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {

            // 요청 정보는 MDCUtils 처리
            String apiName = proceedingJoinPoint.getSignature().getName();
            String reqId = MDCUtils.WEB_LOG_INFO.REQUEST_UID.getKey();
            String startTime = LocalDateTime.ofInstant( Instant.ofEpochMilli(lStartTime), ZoneId.systemDefault()).format( DateTimeFormatter.ISO_DATE_TIME );

            MDCUtils.WEB_LOG_INFO.REQUEST_UID.putValue( reqId );
            MDCUtils.WEB_LOG_INFO.REQUEST_START_TIME.putValue( startTime );
            MDCUtils.LOG_COMMON_INFO.METHOD_NAME.putValue( apiName );
            MDCUtils.LOG_COMMON_INFO.METHOD_ARGS.putValue( Arrays.toString( proceedingJoinPoint.getArgs() ) );
            MDCUtils.LOG_COMMON_INFO.METHOD_RETURN.putValue( result != null ? result.toString() : "{}" );

            apiLog.info("");
        }

        return result;
    }

}
