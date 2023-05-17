package com.sopt.kwy.soptseminar.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class RequestAspect {
    @Pointcut("execution(* com.sopt.kwy.soptseminar.controller..*.*(..))")
    public void executeRequest() {
    }

    @Before("executeRequest()")
    public void beforeRequest(JoinPoint joinPoint) {
        Long userId = (Long) joinPoint.getArgs()[0];
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        System.out.println("userId : " + userId + ", " + method.getName() + "() method execute");
    }
}
