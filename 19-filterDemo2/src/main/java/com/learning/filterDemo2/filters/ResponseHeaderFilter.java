package com.learning.filterDemo2.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
public class ResponseHeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        // Adding headers

        String requestId = UUID.randomUUID().toString();
        httpResponse.setHeader("x-request-id", requestId);

        filterChain.doFilter(servletRequest, servletResponse);

        // We cant do it here but here its immutable, it can't be changed
//        String requestId = UUID.randomUUID().toString();
//        httpResponse.setHeader("x-request-id", requestId);
    }
}
