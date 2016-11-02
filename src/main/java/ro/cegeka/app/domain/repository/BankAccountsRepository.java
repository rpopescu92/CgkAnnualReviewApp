package ro.cegeka.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.cegeka.app.domain.model.BankAccount;
import ro.cegeka.app.domain.model.User;

import java.util.List;

public interface BankAccountsRepository extends JpaRepository<BankAccount, Long> {

    public List<BankAccount> findByUser(User user);

}
