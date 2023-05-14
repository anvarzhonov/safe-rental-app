package ru.anvarzhonov.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;
    public void validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                    .build()
                    .parseClaimsJws(token);
        } catch (SignatureException ex) {
            throwExceptionWithMessage("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            throwExceptionWithMessage("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throwExceptionWithMessage("Expired JWT token. ex: " + ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            throwExceptionWithMessage("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throwExceptionWithMessage("JWT claims string is empty.");
        }
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private void throwExceptionWithMessage(String message) {
        log.error(message);
        throw new RuntimeException(message);
    }
}
