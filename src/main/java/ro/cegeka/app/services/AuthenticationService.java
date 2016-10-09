package ro.cegeka.app.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ro.cegeka.app.domain.model.User;
import ro.cegeka.app.domain.repository.UserRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

@Slf4j
@Component("userDetailsService")
public class AuthenticationService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Inject
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String userName) {
        log.debug("Authenticating user with email {}", userName);

        Optional<User> user = userRepository.findByUserName(userName.toLowerCase(Locale.ENGLISH));
        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }

}
