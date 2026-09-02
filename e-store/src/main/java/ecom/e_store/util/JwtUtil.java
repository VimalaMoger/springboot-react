package ecom.e_store.util;

import ecom.e_store.entity.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import ecom.e_store.constants.ApplicationConstants;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final Environment env;
    private static final String SECRET_KEY ="";
    public String generateJwtToken(Authentication authentication) {
        String jwt = "";
        String secret = env.getProperty(ApplicationConstants.JWT_SECRET_KEY, ApplicationConstants.JWT_SECRET_DEFAULT_VALUE);
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        Customer fetchUser = (Customer) authentication.getPrincipal();
        jwt = Jwts.builder().issuer("e-store").subject("JWT Token")
                .claim("username", fetchUser.getName())
                .claim("email", fetchUser.getEmail())
                .claim("mobileNumber", fetchUser.getMobileNumber())
                .claim("roles", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(", ")))
                .issuedAt(new Date()).expiration(new Date(new Date().getTime() + 60 * 60 * 1000))
                .signWith(secretKey).compact();
        return jwt;
    }
}
