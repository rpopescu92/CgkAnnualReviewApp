package ro.cegeka.app.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ro.cegeka.app.domain.model.User;
import ro.cegeka.app.domain.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Date;

@Component
public class Provisioning {

    @Inject
    private UserRepository userRepository;

 /**@PostConstruct
  public void init() {
      BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
       User user = User.builder().userName("admin").password(bcrypt.encode("roxana")).createdDate(new Date()).build();
        userRepository.save(user);
    }*/
}
