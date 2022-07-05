package com.example.ManagerShoers.common.security;

import com.example.ManagerShoers.common.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class AuthenFilter extends OncePerRequestFilter {
    @Autowired
    private AuthUtil authUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String url = request.getRequestURI();
            if (url.contains("swagger-ui.html") || url.contains("swagger-ui")){
                filterChain.doFilter(request,response);
            }else{
                String accessToken = request.getHeader("accessToken");
                ServiceResponse<Boolean> validToken = authUtil.checkToken(accessToken);
                if (validToken.getCode() == 0){
                    //((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, validToken.getMessage());
                    ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, validToken.getMessage());
                }else{
                    filterChain.doFilter(request, response);
                }
            }
        }catch (Exception e){
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }


    }
}
