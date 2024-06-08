package com.employee.management.config;

import com.employee.management.interceptor.AdminRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig implements WebMvcConfigurer {

    private final AdminRequestInterceptor adminRequestInterceptor;

    public InterceptorConfig(AdminRequestInterceptor adminRequestInterceptor) {
        this.adminRequestInterceptor = adminRequestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminRequestInterceptor).addPathPatterns("/api/**");
    }

}
