package com.lgh.spring.boot.component;

import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.util.ResponseUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/4/22.
 */
@Aspect
@Component
public class ErrorHandler {
    private static Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
    @Pointcut("execution( * com.lgh.spring.boot.controller.rest.*.*(..))")
    public void pointCutAt() {
    }

    @Around("pointCutAt()")
    public Response beforeAction(ProceedingJoinPoint joinPoint) {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method controller = signature.getMethod();
        Response response;
        try {
            response = (Response) joinPoint.proceed();
        }catch (Throwable e){
            response = ResponseUtil.failed(e.getMessage());
        }finally {
            logger.info("[time:{}ms] Request method:{}",System.currentTimeMillis() - beginTime,controller);
        }
        return response;
    }
}
