package ro.cegeka.app.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.cegeka.app.domain.model.BankAccount;
import ro.cegeka.app.domain.model.User;
import ro.cegeka.app.domain.repository.BankAccountsRepository;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountsRepository bankAccountsRepository;

	public void init() {
		for (int i = 0; i < 10; i++) {
			bankAccountsRepository.save(BankAccount.builder().
					id(Long.valueOf(i)).
					accountNumber("100" + i).
					build());        
		}
	}

	public List<BankAccount> getAccountsByUser(String user){
		List<BankAccount> listAccs = new ArrayList<>();
		init();

		BankAccount ba = BankAccount.builder().
				id(Long.valueOf(1)).
				accountNumber("1234").
				balance( new BigDecimal(Long.valueOf(12))).
				build();                
		listAccs.add( ba );

		return listAccs;     
	}

	public void saveAccount(BankAccount bankAccount){
		bankAccountsRepository.save(bankAccount);
	}

	public List<BankAccount> getBankAccountsByUser(User user) {
		return bankAccountsRepository.findByUser(user);
	}
}
