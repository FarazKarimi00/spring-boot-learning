package com.learning.aopDemo3.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(* com.learning.aopDemo3.service.StudentService.*(..))")
//    @Before("within(com.learning.aopDemo3.service.StudentService)")
//    @Before("@annotation(jdk.jfr.Timestamp)")
//    @Before("bean(studentService)")
//    @Before("bean(studentService) || bean(studentController)")


    @Pointcut("within(com.learning.aopDemo3.service..*) " +
            "&&" +
            "execution(public * * (..))")
    public void logPublicServiceMethod() {
        // always empty body
    }


//    @Before("within(com.learning.aopDemo3.service..*) " +
//            "&&" +
//            "execution(public * * (..))")
//    @Before("logPublicServiceMethod()")
//    @Before("com.learning.aopDemo3.aspect.ApplicationPointcuts.publicServiceMethod()")
//    @Before("@within(org.springframework.stereotype.Service)")
//    @Before("@within(org.springframework.stereotype.Service))")
//    public void logBeforeMethod() {
//        System.out.println("Method intercepted (general)");
//    }
//
//    @Before("args(com.learning.aopDemo3.dto.Student) " +
//            "&&" +
//            " within(com.learning.aopDemo3.service..*)")
//    public void logBeforeMethod2() {
//        System.out.println("Method intercepted");
//    }

//    @Before("@args(jdk.jfr.Timestamp) " +
//            "&&" +
//            " within(com.learning.aopDemo3.service..*))")
//    public void logBeforeMethod3() {
//        System.out.println("Method intercepted");
//    }

//    @Before("this(com.learning.aopDemo3.service.StudentService)")
    @Before("target(com.learning.aopDemo3.service.StudentService)")
    public void logBeforeMethod4() {
        System.out.println("Method intercepted");
    }

//    @Before("execution(com.learning.aopDemo3.dto.Student " +
//            "com.learning.aopDemo3.service.StudentService.createStudent(" +
//            "com.learning.aopDemo3.dto.Student))")
//    public void logBeforeMethod2() {
//        System.out.println("Method intercepted ");
//    }

}

