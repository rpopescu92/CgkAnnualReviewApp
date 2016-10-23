package ro.cegeka.app.domain;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import ro.cegeka.app.domain.repository.AccountsRepository;
import ro.cegeka.app.domain.repository.UserRepository;

@Component
public class Provisioning {

    @Inject
    private UserRepository userRepository;
    
    @Inject
    private AccountsRepository accountsRepository;

//    @PostConstruct
//    public void init() {
//        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//        User user = User.builder().userName("admin").password(bcrypt.encode("roxana")).createdDate(new Date()).build();
//        userRepository.save(user);
//    }
}
