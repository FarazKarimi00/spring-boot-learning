package com.learning.filterDemo2.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DummyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String uri = httpRequest.getRequestURI();
        if(!uri.startsWith("/api/")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

        System.out.println("Dummy Filter called");

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
