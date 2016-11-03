package ro.cegeka.app.services;

import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cegeka.app.domain.model.BankAccount;
import ro.cegeka.app.domain.model.User;
import ro.cegeka.app.domain.repository.BankAccountsRepository;
import ro.cegeka.app.dto.BankAccountDTO;

import java.util.Date;
import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountsRepository bankAccountsRepository;

    @Autowired
    private UserService userService;

    public List<BankAccount> getBankAccountsByUser() {
        User user = userService.getAuthenticatedUser();
        return bankAccountsRepository.findByUser(user);
    }

    public void saveBankAccount(BankAccountDTO bankAccountDto) {
        Iban iban = Iban.random(CountryCode.RO);

        BankAccount bankAccount = BankAccount.builder().accountNumber(iban.getAccountNumber())
                .balance(bankAccountDto.getInitialAmount())
                .intialAmount(bankAccountDto.getInitialAmount())
                .currency(bankAccountDto.getCurrency())
                .user(userService.getAuthenticatedUser())
                .createDate(new Date())
                .accountType(bankAccountDto.getAccountType())
                .build();
        bankAccountsRepository.save(bankAccount);
    }


}
