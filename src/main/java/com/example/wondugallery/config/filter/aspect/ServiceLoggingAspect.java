package com.example.wondugallery.config.filter.aspect;

import com.example.wondugallery.utils.MDCUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class ServiceLoggingAspect {

    private static final Logger serviceLog = LoggerFactory.getLogger("SERVICE_LOG");

    private static final Logger log = LoggerFactory.getLogger("log");

    @Around(value = "execution(* com.example.wondugallery..*Service.*(..))")
    public Object serviceLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        Object[] signatureArgs = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();

        Object result = null;
        try {
            result = joinPoint.proceed();
        } finally {

            MDCUtils.put("parameter", params(joinPoint).toString());
            MDCUtils.put("methodName", methodName);
            MDCUtils.put("className", className);


            if (result != null) {
                MDCUtils.put("return", result.toString());
            }

            String requestUID = MDCUtils.get("requestUID");

            sb.append(" / ").append(requestUID);
            serviceLog.info("");
        }

        return result;
    }

    private Map params(ProceedingJoinPoint joinPoint) {
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        String[] parameterNames = codeSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            params.put(parameterNames[i], args[i]);
        }
        return params;
    }

}
