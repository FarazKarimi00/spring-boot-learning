package com.learning.filterDemo2.configuration;

import com.learning.filterDemo2.filters.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilterBean() {

        FilterRegistrationBean<DummyFilter> registrationBean =
                new FilterRegistrationBean<>();

        registrationBean.setFilter(new DummyFilter());
//        registrationBean.setOrder();

        // this filter will run only for the request which starts with /api/anything
        // or another patterns separated by commas
        registrationBean.addUrlPatterns("/api/*", "/admin/*");  // ☝️

        return registrationBean;
    }
}
