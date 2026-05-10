package net.javaguides.expansetrackerapp.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

<<<<<<< HEAD
=======
import java.nio.charset.StandardCharsets;
>>>>>>> 7399c94 (backend ready)
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

<<<<<<< HEAD
    @Value("${app.jwt-expiration-miliseconds}")
=======
    @Value("${app.jwt-expiration-milliseconds}")
>>>>>>> 7399c94 (backend ready)
    private long jwtExpiryDate;

    // Generate jwt Token
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();

        Date currentDate = new Date();

        Date expirationDate = new Date(currentDate.getTime() + jwtExpiryDate);

        String token = Jwts.builder()
                .setSubject(username)
<<<<<<< HEAD
                .setIssuedAt(new Date())
=======
                .setIssuedAt(currentDate)
>>>>>>> 7399c94 (backend ready)
                .setExpiration(expirationDate)
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

<<<<<<< HEAD
    private Key key(){
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret)
=======
    private Key key() {
        return Keys.hmacShaKeyFor(
                jwtSecret.getBytes(StandardCharsets.UTF_8)
>>>>>>> 7399c94 (backend ready)
        );
    }

    //get username form jwt token
    public String getUsername(String token) {
<<<<<<< HEAD
        Claims claims = Jwts.parser()
=======
        Claims claims = Jwts.parserBuilder()
>>>>>>> 7399c94 (backend ready)
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();

        String username = claims.getSubject();

        return username;
    }

    // validate jwt token
    public boolean validateToken(String token) {
<<<<<<< HEAD
        Jwts.parser()
                .setSigningKey(key())
                .build()
                .parse(token);

        return true;

=======
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (Exception ex) {
            return false;
        }
>>>>>>> 7399c94 (backend ready)
    }
}
