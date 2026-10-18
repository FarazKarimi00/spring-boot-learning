package com.learning.aopDemo2.aspect;

import com.learning.aopDemo2.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    //       Point cut expression
    @Before("execution(* com.learning.aopDemo2.service.StudentService.createStudent(..))")
    // JointPoint -> contains all information about the service class method
    public void logBeforeMethod(JoinPoint joinPoint) {

        Object[] arr = joinPoint.getArgs(); // Fills object array with service class method's argument (cannot modify)

        System.out.println("Student is going to be saved");

// //        boolean allowed = false;
// //        if(!allowed) {
// //            throw new RuntimeException("Method execution not allowed");
// //        }
    }

    @AfterReturning(
            pointcut = "execution(" +
                    "* com.learning.aopDemo2" +
                    ".service.StudentService" +
                    ".createStudent(..))",
            returning = "result")
    public void logAfterReturningMethod(Student result) {
// //        System.out.println("logAfterReturningMethod called");
        result.setName("WXYZ");  // Bad coding practice
        result.setAge(50);
        System.out.println("Intercepted create Student");
    }

    @AfterThrowing(
            pointcut = "execution(* com.learning.aopDemo2.service.StudentService.createStudent(..))",
            throwing = "exception")
    public void logAfterThrowingMethod(RuntimeException exception) {
        System.out.println("Exception type: " + exception.getClass().getName());
        System.out.println("Exception message: " + exception.getMessage());
    }

    @After(value = "execution(* com.learning.aopDemo2.service.StudentService.createStudent(..))")
    public void logAfterMethod() {
        System.out.println("Log After method executed");
    }


    @Around(
            value = "execution(* com.learning.aopDemo2.service.StudentService.createStudent(..))"
    )
    public Object logAroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Starting: " + proceedingJoinPoint.getSignature().getName());

// //        Student result = (Student) proceedingJoinPoint.proceed();
//
        try {
            Object result = proceedingJoinPoint.proceed();

            System.out.println("Execution successful");

            return result;
        } catch (Exception e) {
            System.out.println("Execution failed: " + e.getMessage()) ;
            throw e;
        }
        finally {
            System.out.println("Execution completed");
        }

// //        System.out.println("After target method");

// //        result.setName("WXYZ");
// //        result.setAge(99);
//
    }

    @Around(
            value = "execution(* com.learning.aopDemo2.service.StudentService.dummyMethod(..))"
    )
    public Object logAroundMethod2(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] arr = joinPoint.getArgs();
        String originalString = (String)arr[0];

        String modifiedString = originalString.toUpperCase();

        Object[] modifiedArr = {modifiedString};

        String returnType = (String) joinPoint.proceed(modifiedArr);

        returnType = returnType + " : String intercepted";
        return returnType;


//        Object return1 = joinPoint.proceed();
//        System.out.println("Intercepted request calling again");
//        Object return2 = joinPoint.proceed();
//        return return2;
    }

}
