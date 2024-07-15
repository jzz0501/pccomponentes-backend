package com.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JWT {

    private static final String signKey = "!23Aad232asdXZCK23Aad232asdXZCK23Aad232asdXZCK23Aad232asdXZCK";

    private static final Long expire = 600000L;

    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .claims(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expire))
                .signWith(Keys.hmacShaKeyFor(signKey.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    public static Claims parseJwt(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(signKey.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
