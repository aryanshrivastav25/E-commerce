package com.restJob.restJob.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    @Around("execution(* com.restJob.restJob.service.JobService.getAllJobs(..)) || execution(* com.restJob.restJob.service.JobService.getJob(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable
    {
        long start = System.currentTimeMillis();

        Object o = jp.proceed(); // In between the start and end, we have to specify when the method is to be called.

        long end = System.currentTimeMillis();
        LOGGER.info("Execution time of " + jp.getSignature().getName() + " is " + (end - start) + " ms");

        return o;
    }
    // It is compulsory to return the JoinPoint object in Around advice
}
