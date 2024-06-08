package com.employee.management.interceptor;


import com.employee.management.exception.UnauthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminRequestInterceptor implements HandlerInterceptor {

    private static final String AUTH_TOKEN = "8X3GK-2H9F4-P7D6Q";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws UnauthorizedException {
        String token = httpServletRequest.getHeader("x-api-token");
        if (StringUtils.isEmpty(token) || !AUTH_TOKEN.equals(token)) {
            throw new UnauthorizedException("Invalid AUTH_TOKEN: " + token);
        }

        return true;
    }

}
