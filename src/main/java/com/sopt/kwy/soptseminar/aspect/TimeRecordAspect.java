package com.sopt.kwy.soptseminar.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeRecordAspect {
    private long beforeTime;
    private long afterTime;

    @Pointcut("execution(* com.sopt.kwy.soptseminar.controller..*.*(..))")
    public void executeTimeRecord() {
    }

    @Before("executeTimeRecord()")
    public void beforeTimeRecord() {
        beforeTime = System.currentTimeMillis();
    }

    @AfterReturning(pointcut = "executeTimeRecord()")
    public void AfterTimeRecord() {
        afterTime = System.currentTimeMillis();
        System.out.println("코드 수행 시간(ms) : " + (afterTime - beforeTime) + "ms");
    }
}
