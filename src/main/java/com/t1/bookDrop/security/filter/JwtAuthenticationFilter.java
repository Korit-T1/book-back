package com.t1.bookDrop.security.filter;

import com.t1.bookDrop.jwt.JwtProvider;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends GenericFilter {

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Boolean isPermitAll = (Boolean) request.getAttribute("isPermitAll");
        System.out.println("isPermitAll: " + isPermitAll);

        if(!isPermitAll) {
            String accessToken = request.getHeader("Authorization");
            String removedBearerToken = jwtProvider.removeBearer(accessToken);
            System.out.println("removedBearerToken: " + removedBearerToken);
            Claims claims = null;

            try {
                claims = jwtProvider.getClaims(removedBearerToken);    
            } catch (Exception e) {
                System.out.println(claims);
                System.out.println("claims 오류");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            Authentication authentication = jwtProvider.getAuthentication(claims);

            if(authentication == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            System.out.println(authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
