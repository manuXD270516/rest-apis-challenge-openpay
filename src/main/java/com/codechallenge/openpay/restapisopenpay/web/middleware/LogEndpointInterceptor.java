package com.codechallenge.openpay.restapisopenpay.web.middleware;

import com.codechallenge.openpay.restapisopenpay.service.LogEndpointService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@AllArgsConstructor
public class LogEndpointInterceptor implements HandlerInterceptor {

    private  LogEndpointService logEndpointService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logEndpointService.saveLog(request.getRequestURI());
        return true;
    }
}
