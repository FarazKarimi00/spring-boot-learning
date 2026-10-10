package com.learning.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component

// Used for combining filters
@Order(2)  // This will execute after Authentication filter
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("Request Entered in Logging filter");
//        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("Request exiting in logging filter");

        long startTime = System.currentTimeMillis();

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String requestId = UUID.randomUUID().toString();

        httpResponse.setHeader("X-Request-ID",requestId);

        // Request log
        System.out.println("Incoming request: " +
                httpRequest.getMethod() + " " +
                httpRequest.getRequestURI());

        try{
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            long duration = System.currentTimeMillis() - startTime;

            // Response method log
            System.out.println("Response status: " + httpResponse.getStatus());
            System.out.println("API response time: " + duration);
        }
    }
}
