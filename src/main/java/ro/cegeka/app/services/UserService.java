package ro.cegeka.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ro.cegeka.app.domain.model.User;
import ro.cegeka.app.domain.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by roxana on 25.05.2016.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void init() {
        for (int i = 0; i < 10; i++) {
            userRepository.save(User
                    .builder()
                    .id(Long.valueOf(i))
                    .firstName("Mihai" + i)
                    .lastName("Popescu" + i)
                    .createdDate(new Date())
                    .password("fasdsfufgjhdhkasdnsad" + i)
                    .build());
        }
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        Optional<User> optional = userRepository.findByUserName(authentication.getName());
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Optional<User> getAuthenticatedUserAsOptional() {
        return Optional.ofNullable(getAuthenticatedUser());
    }
}
