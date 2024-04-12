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
        if(!isPermitAll) {
            String accessToken = request.getHeader("Authorization");
            String removedBearerToken = jwtProvider.removeBearer(accessToken);
            Claims claims = null;

            try {
                claims = jwtProvider.getClaims(removedBearerToken);         // 토큰으로 claim 가져오기
            } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);    // 401 Error (인증 실패)
//                response.sendError(HttpStatus.UNAUTHORIZED);
//                response.sendError(401);
                return;
            }

            Authentication authentication = jwtProvider.getAuthentication(claims);

            if(authentication == null) {                                    // 추출한 claim을 기반으로 인증실패한 경우
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);    // 마찬가지로 인증 실패
                return;
            }
            SecurityContextHolder.getContext().setAuthentication(authentication);   // null 일 때 403 Error
        }

        // 전처리
        filterChain.doFilter(request, response);
        // 후처리
    }

}
