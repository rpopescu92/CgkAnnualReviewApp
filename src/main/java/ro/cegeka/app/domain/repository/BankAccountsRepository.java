package ro.cegeka.app.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.cegeka.app.domain.model.BankAccount;
import ro.cegeka.app.domain.model.User;

import java.util.List;

public interface BankAccountsRepository extends JpaRepository<BankAccount, Long> {

    Page<BankAccount> findByUser(User user, Pageable pageable);

    List<BankAccount> findByUser(User user);

}
