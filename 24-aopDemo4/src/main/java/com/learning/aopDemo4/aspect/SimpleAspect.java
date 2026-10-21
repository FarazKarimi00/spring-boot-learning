package com.learning.aopDemo4.aspect;

import com.learning.aopDemo4.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

//    @Before("@annotation(jdk.jfr.Timestamp)")
//    public void logBeforeMethod() {
//        System.out.println("Method intercepted");
//    }

//    @Around("@annotation(com.learning.aopDemo4.annotation.TrackExecutionTime)")
    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint,
                                       TrackExecutionTime trackExecutionTime)
            throws Throwable {
        long startTime = System.nanoTime();
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            double duration = (System.nanoTime() - startTime) / 1_000_000.0;
            String operation = trackExecutionTime.operation();
            if(operation.isBlank()) {
                operation = proceedingJoinPoint.getSignature().getName();
            }
            long warningThreshold = trackExecutionTime.warnAfter();
            if(duration >= warningThreshold) {
                System.out.println("SLOW OPERATION ALERT :" +
                        " Time taken by" + operation + ": " + duration + "ms" );
            } else {
                System.out.println(
                        "Time taken by " + operation + ": " + duration + "ms");
            }
        }
    }
}
