package com.learning.filterDemo2.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String token = httpRequest.getHeader("token");
        if(token == null || !token.equals("12345")) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Authentication is required\"\n" +
                            "}"
            );
            return;
        }

        // After this line request goes to dispatcher servlet if there are no more filters
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
