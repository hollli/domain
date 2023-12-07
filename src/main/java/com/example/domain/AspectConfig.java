package com.example.domain;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectConfig {

    @Pointcut("execution(* com.example.domain.Service.performAction(..))")
    public void serviceMethods() {
    }

    @Before("serviceMethods()")
    public void beforeServiceMethod(JoinPoint joinPoint) {
        System.out.println("Before executing Service method: " + joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void afterReturningServiceMethod(JoinPoint joinPoint, Object result) {
        System.out.println("After executing Service method: " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "exception")
    public void afterThrowingServiceMethod(JoinPoint joinPoint, Throwable exception) {
        System.out.println("Exception in Service method: " + joinPoint.getSignature().toShortString() + ", Exception: " + exception.getMessage());
    }

    @Pointcut("execution(* com.example.domain.FirstLevelService.performAction(..))")
    private void firstLevelServiceMethods() {}

    @Pointcut("execution(* com.example.domain.SecondLevelService.performAction(..))")
    private void secondLevelServiceMethods() {}

    @Pointcut("firstLevelServiceMethods() || secondLevelServiceMethods()")
    private void combinedPointcut() {}

    @Before("combinedPointcut()")
    public void beforeCombinedPointcut(JoinPoint joinPoint) {
        System.out.println("Before executing Combined Pointcut: " + joinPoint.getSignature().toShortString());
    }
}
