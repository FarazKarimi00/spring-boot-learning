package com.learning.aopDemo3.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcuts {

    @Pointcut("within(com.learning.aopDemo3.controller..*)")
    public void controllerLayer() {
        // Empty body
    }

    @Pointcut("within(com.learning.aopDemo3.service..*)")
    public void serviceLayer() {
        // Empty body
    }

    @Pointcut("execution(public * *(..))")
    public void publicMethod() {
        // Empty Body
    }

    @Pointcut("serviceLayer() && publicMethod()")
    public void publicServiceMethod() {
        // Empty body
    }

    @Pointcut("execution(* *.get* (..))")
    public void getterMethod() {

    }
}
