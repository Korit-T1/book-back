package com.t1.bookDrop.jwt;

import com.t1.bookDrop.entity.Admin;
import com.t1.bookDrop.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {

    private final Key key;

    private JwtProvider(@Value("${jwt.secret}") String secret) {
        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public String generateToken(User user) {
        int userId = user.getUserId();
        String username = user.getUsername();
        Date expireDate = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));

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
        Date expireDate = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));

        String accessToken = Jwts.builder()
                .claim("adminId", adminId)
                .claim("username", username)
                .setExpiration(expireDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return accessToken;
    }
}
