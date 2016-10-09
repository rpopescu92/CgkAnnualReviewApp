package ro.cegeka.app.resources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.cegeka.app.domain.model.Authentication;
import ro.cegeka.app.security.AuthorizationConfigurer;
import ro.cegeka.app.security.TokenProvider;
import ro.cegeka.app.util.JwtToken;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Collections;

@Slf4j
@RestController
@RequestMapping("/api")
public class AuthenticationResource {

    @Inject
    private TokenProvider tokenProvider;
    @Inject
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authorize(@Valid @RequestBody Authentication auth, HttpServletResponse response) {
        log.debug("Authenticating user with username {}", auth.getUserName());

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(auth.getUserName(), auth.getPassword());
        try {
            org.springframework.security.core.Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.createToken(authentication, auth.isRememberMe());
            response.addHeader(AuthorizationConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);

            log.debug("User with email {} successfully authenticated", auth.getUserName());

            return ResponseEntity.ok(new JwtToken(jwt));
        } catch (AuthenticationException e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(Collections.singletonMap("AuthenticationException", "Invalid username or password"), HttpStatus.UNAUTHORIZED);
        }
    }

}
