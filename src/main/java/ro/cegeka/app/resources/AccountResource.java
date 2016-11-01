package ro.cegeka.app.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.cegeka.app.domain.model.BankAccount;
import ro.cegeka.app.domain.model.User;
import ro.cegeka.app.services.UserService;

import javax.inject.Inject;

/**
 * Created by roxana on 09.10.2016.
 */
@RestController
@RequestMapping("/api")
public class AccountResource {

    @Inject
    private UserService userService;

    @RequestMapping(value = "/account", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getAccount(){
        return userService.getAuthenticatedUserAsOptional()
                .map(user-> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }



}
