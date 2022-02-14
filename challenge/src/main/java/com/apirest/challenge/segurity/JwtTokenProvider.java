package com.apirest.challenge.segurity;

import com.apirest.challenge.exceptions.BlogAppException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    public String generarToken(Authentication authentication) {
        String username = authentication.getName();
        String token = Jwts.builder().setSubject(username).signWith(SignatureAlgorithm.HS512,jwtSecret).compact();
        return token;
    }

    public String obtenerUsernameDelJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"Firma JWT no valida");
        }
        catch (MalformedJwtException ex) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"Token JWT no valida");
        }
        catch (ExpiredJwtException ex) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"Token JWT caducado");
        }
        catch (UnsupportedJwtException ex) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"Token JWT no compatible");
        }
        catch (IllegalArgumentException ex) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"La cadena claims JWT esta vacia");
        }
    }
}

