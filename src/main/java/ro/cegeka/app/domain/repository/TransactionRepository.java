package ro.cegeka.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.cegeka.app.domain.model.Transaction;
import ro.cegeka.app.domain.model.User;

import java.util.Optional;

/**
 * Created by roxanap on 03.11.2016.
 */
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    public Optional<Transaction> findByUser(User user);
}
