package com.learning.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1) // This will execute first then Logging filter will execute
public class AuthenticationFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String token = httpRequest.getHeader("token");

        String apiKey = httpRequest.getHeader("X-api-key");

        if(token == null || !token.equals("12345")) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 -> unauthorized
            return;
        }
        if(apiKey == null || !apiKey.equals("secret123")) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Invalid or missing api key\"\n" +
                            "}"
            );
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
