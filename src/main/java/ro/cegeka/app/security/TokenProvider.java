package ro.cegeka.app.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import ro.cegeka.app.util.JwtSecurityDetails;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TokenProvider {

    private static final String AUTHORITIES_KEY = "auth";

    private String secretKey;
    private long tokenValidityInSeconds;

    @Inject
    private JwtSecurityDetails jwtSecurityDetails;

    @PostConstruct
    public void init() {
        this.secretKey = jwtSecurityDetails.getSecret();
        this.tokenValidityInSeconds = 1000 * Long.valueOf(jwtSecurityDetails.getTokenValidityInSeconds());
    }

    public String createToken(Authentication authentication, Boolean rememberMe) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        Date validity = new Date(now + this.tokenValidityInSeconds);

        return Jwts.builder().setSubject(authentication.getName()).claim(AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS512, secretKey).setExpiration(validity).compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();

        User principal = new User(claims.getSubject(), "", new ArrayList<>());

        return new UsernamePasswordAuthenticationToken(principal, "", new ArrayList<>());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.info("Invalid JWT signature: " + e.getMessage());
            return false;
        }
    }

}
