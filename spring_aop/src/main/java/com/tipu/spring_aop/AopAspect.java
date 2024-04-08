package com.tipu.spring_aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
public class AopAspect {
    Logger logger = LoggerFactory.getLogger(AopAspect.class);

    @Before("execution(* AopClass+.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info("Before Strarting - "+joinPoint.getSignature().getName()+" method with parameter - "+ Arrays.toString(joinPoint.getArgs()));
    }

    //After execution
//    @After("execution(* AopClass+.*(..))")
//    public void after(JoinPoint joinPoint){
//        logger.info("After Finishing - "+joinPoint.getSignature().getName()+" method with parameter - "+ Arrays.toString(joinPoint.getArgs()));
//    }

    @AfterReturning(value = "execution(* AopClass+.*(..))", returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result){
        logger.info("After Finishing - "+joinPoint.getSignature().getName()+" method with return - "+ result);
    }

    @Before("execution(* AnotherClass+.*(..))")
    public void before1(JoinPoint joinPoint){
        logger.info("Before Strarting - "+joinPoint.getSignature().getName()+" method with parameter - "+ Arrays.toString(joinPoint.getArgs()));
    }
}
