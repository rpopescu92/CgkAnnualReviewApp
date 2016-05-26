package ro.cegeka.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cegeka.app.domain.model.UserEntity;
import ro.cegeka.app.domain.repository.UserRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by roxana on 25.05.2016.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void init() {
        for (int i = 0; i < 10; i++) {
            userRepository.save(UserEntity
                    .builder()
                    .id(Long.valueOf(i))
                    .firstName("Mihai" + i)
                    .lastName("Popescu" + i)
                    .createdDate(new Date())
                    .password("fasdsfufgjhdhkasdnsad" + i)
                    .build());
        }
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
