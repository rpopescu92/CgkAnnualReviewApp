package ro.cegeka.app.services;

import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.cegeka.app.domain.model.BankAccount;
import ro.cegeka.app.domain.model.User;
import ro.cegeka.app.domain.repository.BankAccountsRepository;
import ro.cegeka.app.dto.BankAccountDTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountsRepository bankAccountsRepository;

    @Autowired
    private UserService userService;

    public Page<BankAccount> getBankAccountsByUser(Integer page, Integer limit, String option) {
        User user = userService.getAuthenticatedUser();
        Sort.Direction direction = option.startsWith("-") ? Sort.Direction.DESC : Sort.Direction.ASC;
        if (option.startsWith("+")) {
            option = option.substring(option.indexOf('+') + 1);
        } else {
            option = option.substring(option.indexOf('-') + 1);
        }
        return bankAccountsRepository.findByUser(user, new PageRequest(page - 1, limit, direction, option));
    }

    public void saveBankAccount(BankAccountDTO bankAccountDto) {
        Iban iban = Iban.random(CountryCode.RO);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(new Date());

        BankAccount bankAccount = BankAccount.builder().accountNumber(iban.getAccountNumber())
                .balance(bankAccountDto.getInitialAmount())
                .initialAmount(bankAccountDto.getInitialAmount())
                .currency(bankAccountDto.getCurrency())
                .user(userService.getAuthenticatedUser())
                .createdDate(date)
                .accountType(bankAccountDto.getAccountType())
                .build();
        bankAccountsRepository.save(bankAccount);
    }


    public void deleteAccount(Long id) {
        bankAccountsRepository.delete(id);
    }

    public List<BankAccount> getBankAccountNamesByUser() {
        User user = userService.getAuthenticatedUser();
        return bankAccountsRepository.findByUser(user);
    }
}
