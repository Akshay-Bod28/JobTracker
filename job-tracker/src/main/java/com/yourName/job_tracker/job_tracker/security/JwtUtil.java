package com.yourName.job_tracker.job_tracker.security;

import io.jsonwebtoken.Claims; //represent JWT Data
import io.jsonwebtoken.Jwts; //Create/Parse JWT
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date; //Token Expiration
import java.util.function.Function;

@Component
public class JwtUtil {

    private final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build(); //secret key
    private final long JWT_EXPIRATION = 86400000; //24 hours before expiring

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
        .verifyWith(SECRET_KEY)
        .build()
        .parseSignedClaims(token)
        .getPayload(); //get data from JSON
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token) {
        Date currTime = new Date();
        Date expireDate = extractExpiration(token);
        if (expireDate.before(currTime)) {
            return true;
        } else {
            return false;
        }
    }

    public String generateToken(String email) {
        return Jwts.builder()
        .subject(email)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis()+JWT_EXPIRATION)) //expires 1 day after creation
        .signWith(SECRET_KEY) 
        .compact(); //build
    }

    public Boolean validateToken(String token, String email) {
        String tokenEmail = extractEmail(token);
        //check if the token's email and given email are same
        //Make sure token isn't expired
        if (email.equals(tokenEmail) && !isTokenExpired(token)) {
            return true;
        } else {
            return false;
        }
    }
}
