package com.faraz.interceptorDemo.config;

import com.faraz.interceptorDemo.interceptor.AuthenticationInterceptor;
import com.faraz.interceptorDemo.interceptor.AuthorizationInterceptor;
import com.faraz.interceptorDemo.interceptor.LoggingInterceptor;
import com.faraz.interceptorDemo.interceptor.PerformanceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoggingInterceptor loggingInterceptor;
    private final AuthenticationInterceptor authenticationInterceptor;
    private final AuthorizationInterceptor authorizationInterceptor;
    private final PerformanceInterceptor performanceInterceptor;

    public WebConfig(LoggingInterceptor loggingInterceptor,
                     AuthenticationInterceptor authenticationInterceptor,
                     AuthorizationInterceptor authorizationInterceptor,
                     PerformanceInterceptor performanceInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
        this.performanceInterceptor = performanceInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/api/**")
                .order(1);

        registry.addInterceptor(performanceInterceptor)
                .addPathPatterns("/api/**")
                .order(2);

        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .order(3);

        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/api/**")
                .order(4);
    }
}
