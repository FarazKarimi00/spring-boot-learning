package com.faraz.interceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        System.out.println("------ Incoming Request ------");
        System.out.println("HTTP method: " + request.getMethod());
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("Request parameters: " + request.getQueryString());
        System.out.println("Client IP: " + request.getRemoteAddr());
        System.out.println("Token present: " + (request.getHeader("token") != null));

        if(handler instanceof HandlerMethod handlerMethod) {
            System.out.println("Controller: " + handlerMethod.getBeanType().getName());
            System.out.println("Method: " + handlerMethod.getMethod().getName());
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {

        System.out.println("Response status: " + response.getStatus());
        System.out.println();
    }
}
