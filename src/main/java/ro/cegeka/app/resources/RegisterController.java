package ro.cegeka.app.resources;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.cegeka.app.domain.model.User;
import ro.cegeka.app.services.UserService;

import java.util.Date;

/**
 * Created by roxanap on 23.10.2016.
 */
@RestController
@RequestMapping("/register")
@Slf4j
public class RegisterController {

    public static final int SQL_DUPLICATE_USERNAME = 1062;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody User user) {
        log.info("Registering user with user name " + user.getUserName());
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encodedPassword = bcrypt.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setCreatedDate(new Date());
        try {
            userService.registerUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            if (ex.getCause() instanceof ConstraintViolationException) {
                return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
