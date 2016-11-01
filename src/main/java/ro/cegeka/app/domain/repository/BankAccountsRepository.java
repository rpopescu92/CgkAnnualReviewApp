package ro.cegeka.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.cegeka.app.domain.model.BankAccount;

public interface BankAccountsRepository extends JpaRepository<BankAccount, Long> {

}
