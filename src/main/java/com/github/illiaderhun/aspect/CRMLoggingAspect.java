package com.github.illiaderhun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private final Logger LOGGER = Logger.getLogger(getClass().getSimpleName());

    @Pointcut("execution(* com.github.illiaderhun.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.github.illiaderhun.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.github.illiaderhun.dto.*.*(..))")
    private void forDTOPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDTOPackage()")
    private void forAppFlow() {
    }

    // @Before advices

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        String theMethod = theJoinPoint.getSignature().toShortString();
        LOGGER.info("======>>>>>> in @Before: calling method: " + theMethod);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            LOGGER.info("======>>>>>> argument: " + tempArg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

        String theMethod = theJoinPoint.getSignature().toShortString();
        LOGGER.info("======>>>>>> in @AfterReturning: from method: " + theMethod);

        LOGGER.info("======>>>>>> result: " + theResult);
    }
}
