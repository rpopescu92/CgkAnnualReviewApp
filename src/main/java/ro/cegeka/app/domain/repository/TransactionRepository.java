package ro.cegeka.app.domain.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.cegeka.app.domain.model.Transaction;
import ro.cegeka.app.domain.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by roxanap on 03.11.2016.
 */
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
     Optional<Transaction> findByUser(User user);

    @Query(value = "select t from Transaction t where t.user.id = ?1 order by t.date desc")
    List<Transaction> getLastTransactions(Long userId, Pageable pageable);
}
