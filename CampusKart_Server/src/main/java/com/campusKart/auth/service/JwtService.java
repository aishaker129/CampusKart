package com.campusKart.auth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private static final String SECRET_KEY = "abcdefghidklmnop1234567890987654321qrstuvwxyz";

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }
    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+8400000))
                .signWith(getSignKey(),SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUserName(String token){
        return Jwts
                .parser().setSigningKey(getSignKey())
                .build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        return  extractUserName(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
        return Jwts.parser().setSigningKey(getSignKey())
                .build().parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }

}
