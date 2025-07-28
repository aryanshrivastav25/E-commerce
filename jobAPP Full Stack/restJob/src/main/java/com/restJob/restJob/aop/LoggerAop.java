package com.restJob.restJob.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAop {
    // for logging in a file, set logging.file.name=my.log in application.properties
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAop.class);

    // return type, class name(including package), method name, arguments
    // "execution(List<JobPost> com.restJob.restJob.service.getAllJobs())" => class name on which the advice method logMethodCalls is to be exeucted
    // If we want advice on all the methods, then use "exeuction(* *.*(..))" => Which is first * is all the return types, second star is all packages, third star is all methods, and (..) means all the arguments

    // Before advice for all methods of service class
    // @Before is Advice, "execution(* com.restJob.restJob.service.JobService.getAllJobs(..))" is PointCut, LoggerAOP.class in Aspect
    @Before("execution(* com.restJob.restJob.service.JobService.getAllJobs(..)) || execution(* com.restJob.restJob.service.JobService.getJob(..))")
    public void logMethodCall(JoinPoint jp)
    {
        LOGGER.info("Method called " + jp.getSignature().getName()); // Will be called whenever a method gets called
    }

    @After("execution(* com.restJob.restJob.service.JobService.getAllJobs(..)) || execution(* com.restJob.restJob.service.JobService.getJob(..))")
    public void logMethodExecute(JoinPoint jp)
    {
        LOGGER.info("Method executed " + jp.getSignature().getName()); // Will be called whenever a method gets called
    }

    @AfterThrowing("execution(* com.restJob.restJob.service.JobService.getAllJobs(..)) || execution(* com.restJob.restJob.service.JobService.getJob(..))")
    public void logMethodCrash(JoinPoint jp)
    {
        LOGGER.info("Method hash some issues " + jp.getSignature().getName()); // Will be called whenever a method gets called
    }

    @AfterReturning("execution(* com.restJob.restJob.service.JobService.getAllJobs(..)) || execution(* com.restJob.restJob.service.JobService.getJob(..))")
    public void logMethodReturned(JoinPoint jp)
    {
        LOGGER.info("Method returned " + jp.getSignature().getName()); // Will be called whenever a method gets called
    }

    // @After => After finally, will be executed whether there will be exception or not
    // @AfterReturning => After function call returns
    // @AfterThrowing => When function call gets exception 
}
