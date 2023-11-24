package com.gpt806.ezs.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.gpt806.ezs.service.*.*(..))")
    public void logBeforeServiceMethods(JoinPoint joinPoint) {
    }

    @AfterReturning(pointcut = "execution(* com.gpt806.ezs.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
    }

    @Before("execution(* com.gpt806.ezs.controller.*.*(..))")
    public void logBeforeControllerMethods(JoinPoint joinPoint) {
        log.debug("inte: {}",joinPoint.toString());
    }

    @AfterReturning(pointcut = "execution(* com.gpt806.ezs.controller.*.*(..))", returning = "result")
    public void logAfterControllerReturning(JoinPoint joinPoint, Object result) {
        log.debug("inte: {}",result);

    }
    @AfterThrowing(pointcut = "execution(* com.gpt806.ezs.controller.*.*(..))", throwing = "ex")
    public void logServiceError(JoinPoint joinPoint, Exception ex) {
    }

}
