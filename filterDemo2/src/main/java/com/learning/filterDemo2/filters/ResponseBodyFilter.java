package com.learning.filterDemo2.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

// Not a good practice

//@Component
public class ResponseBodyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        ContentCachingResponseWrapper wrappedResponse =
                new ContentCachingResponseWrapper(httpResponse);

        filterChain.doFilter(servletRequest, wrappedResponse);

        // Below lines executes when request comes back from dispatcher servlet
        byte[] originalBodyBytes =  wrappedResponse.getContentAsByteArray();

        String originalBody = new String(originalBodyBytes);

        String modifiedBody =
                """
                {
                    "original response" : %s,
                    "app name" : "Student management system"
                }
                """.formatted(originalBody);

        wrappedResponse.resetBuffer();
        wrappedResponse.getWriter().write(modifiedBody);
        wrappedResponse.copyBodyToResponse();
    }
}
