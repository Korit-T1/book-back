package com.t1.bookDrop.jwt;

import com.t1.bookDrop.entity.Admin;
import com.t1.bookDrop.entity.User;
import com.t1.bookDrop.repository.AdminMapper;
import com.t1.bookDrop.repository.UserMapper;
import com.t1.bookDrop.security.PrincipalUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Collection;
import java.util.Date;

@Component
public class JwtProvider {

    private final Key key;

    private UserMapper userMapper;
    private AdminMapper adminMapper;

    private JwtProvider(@Value("${jwt.secret}") String secret,
                        @Autowired UserMapper userMapper,
                        @Autowired AdminMapper adminMapper) {
        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        this.userMapper = userMapper;
        this.adminMapper = adminMapper;
    }

    public String generateToken(User user) {
        int userId = user.getUserId();
        String username = user.getUsername();
        Date expireDate = new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 20));

        String accessToken = Jwts.builder()
                .claim("userId", userId)
                .claim("username", username)
                .setExpiration(expireDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return accessToken;
    }

    public String generateAdminToken(Admin admin) {
        int adminId = admin.getAdminId();
        String username = admin.getUsername();
        Date expireDate = new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 20));


        String accessToken = Jwts.builder()
                .claim("adminId", adminId)
                .claim("username", username)
                .setExpiration(expireDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return accessToken;
    }

    public String removeBearer(String token) {
        if(!StringUtils.hasText(token)) {   
            return null;
        }

        return token.substring("Bearer ".length());
    }

    public Claims getClaims(String token) {
        Claims claims = null;

        claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims;
    }

    public Authentication getAuthentication(Claims claims) {
        String username = claims.get("username").toString();

        if(username.equals("admin")) {
            Admin admin = adminMapper.adminCheckByUsername(username);

            if (admin == null) return null;
            PrincipalUser principalAdmin = admin.toPrincipalAdmin();
            return new UsernamePasswordAuthenticationToken(
                    principalAdmin,
                    principalAdmin.getPassword(),
                    principalAdmin.getAuthorities()
            );
        }else {
            User user = userMapper.userCheckByUsername(username);
            if (user == null) return null;
            PrincipalUser principalUser = user.toPrincipalUser();
            return new UsernamePasswordAuthenticationToken(
                    principalUser,
                    principalUser.getPassword(),
                    principalUser.getAuthorities()
            );
        }
    }
}
