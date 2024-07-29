package com.uni.common;


import io.jsonwebtoken.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
public class JwtTest {
    private static final long ONE_DAY_TIME = 1000 * 60 * 60 * 24;
    private static final String SIGNATURE ="admin";
    @Test
    public void createJwtToken() {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                // Header
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                // payload
                .claim("username", "xiaozhu")
                .claim("password", "123456")
                // expire
                .setExpiration(new Date(System.currentTimeMillis() + ONE_DAY_TIME)) // 设置jwt的有效时间为一整天
                // subject
                .setSubject("admin")
                // id
                .setId(UUID.randomUUID().toString())
                // algorithm with signature
                .signWith(SignatureAlgorithm.HS256, SIGNATURE)
                // compact
                .compact().toString();
        System.out.println("jwtToken = " + jwtToken);
        // eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InhpYW96aHUiLCJwYXNzd29yZCI6IjEyMzQ1NiIsImV4cCI6MTcyMjMwNDE5OSwic3ViIjoiYWRtaW4iLCJqdGkiOiI2ZTAzOGViYi1hZjY5LTQ1MTQtODliMS1lMzI4NjZlYWMzYTUifQ.a6W8MM9t7kpS7blzP-XI1WBtmZF56OqqzGZyBE4ZpYI
    }

    @Test
    public void parseJwtToken() {
        String jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InhpYW96aHUiLCJwYXNzd29yZCI6IjEyMzQ1NiIsImV4cCI6MTcyMjMwNDE5OSwic3ViIjoiYWRtaW4iLCJqdGkiOiI2ZTAzOGViYi1hZjY5LTQ1MTQtODliMS1lMzI4NjZlYWMzYTUifQ.a6W8MM9t7kpS7blzP-XI1WBtmZF56OqqzGZyBE4ZpYI";
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(SIGNATURE).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        System.out.println("claims = " + claims);
        System.out.println("claims.getSubject() = " + claims.getSubject());
        System.out.println("claims.getExpiration() = " + claims.getExpiration());
        System.out.println("claims.getId() = " + claims.getId());
        System.out.println("claims.username = " + claims.get("username"));
    }
}