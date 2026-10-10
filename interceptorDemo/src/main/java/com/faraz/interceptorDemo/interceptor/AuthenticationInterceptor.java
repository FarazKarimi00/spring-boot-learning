package com.faraz.interceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class AuthenticationInterceptor implements HandlerInterceptor  {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String apiKey = request.getHeader("x-api-key");

        if(!"secret123".equals(apiKey)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            response.getWriter().write(
                    "{\n" +
                            "    \"message\": \"Missing or invalid API key\"\n" +
                            "}"
            );
            return false;
        }

        return true;
    }
}
