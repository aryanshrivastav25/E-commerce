package com.restJob.restJob.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidateAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateAspect.class);

    @Around("(execution(* com.restJob.restJob.service.JobService.getAllJobs(..))) || (execution(* com.restJob.restJob.service.JobService.getJob(..)))")
    // && args(jobId) is used to get the argument of the mapping getJob(jobId is passed in the url as jobPost/{id}, and this id is accessed as jobId by this Advice)
    public Object validateAndUpdate(ProceedingJoinPoint jp) throws Throwable
    {
        if (jp.getSignature().getName().equals("getJob"))
        {
            Object[] args = jp.getArgs();
            System.out.println(args);
            if ((int) args[0] < 0)
                args[0] = - (int) args[0];
            LOGGER.info("PostId is updated " + args[0]);
            // Just updating jobId in the function does not update the actual value, so we need to pass it to the proceed function
            Object obj = jp.proceed(args);
            return obj;
        }
        
        Object obj = jp.proceed();
        

        return obj;
    } 
}
