package ro.cegeka.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cegeka.app.domain.model.UserEntity;

/**
 * Created by roxana on 25.05.2016.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
