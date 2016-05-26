package ro.cegeka.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.cegeka.app.domain.model.UserEntity;
import ro.cegeka.app.services.UserService;

import java.util.List;

/**
 * Created by roxana on 25.05.2016.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserEntity> getUsers() {
        userService.init();
        return userService.getUsers();
    }
}
