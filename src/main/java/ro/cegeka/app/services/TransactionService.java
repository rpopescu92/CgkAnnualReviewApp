package ro.cegeka.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ro.cegeka.app.domain.model.BankAccount;
import ro.cegeka.app.domain.model.Transaction;
import ro.cegeka.app.domain.model.User;
import ro.cegeka.app.domain.repository.BankAccountsRepository;
import ro.cegeka.app.domain.repository.TransactionRepository;
import ro.cegeka.app.dto.TransactionDTO;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by roxanap on 03.11.2016.
 */
@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BankAccountsRepository bankAccountsRepository;
    @Autowired
    private UserService userService;

    public void createTransaction(TransactionDTO transactionDTO){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(new Date());
        User user = userService.getAuthenticatedUser();
        BankAccount bankAccountSender = updateBalance(transactionDTO);

        Transaction transaction = Transaction.builder().amount(transactionDTO.getAmount())
                                    .date(new Date())
                                    .dateString(date)
                                    .sendAccount(bankAccountSender)
                                    .destinationAccount(transactionDTO.getDestinationAccount())
                                    .user(user).build();
        transactionRepository.save(transaction);
    }

    public Optional<Transaction> getTransactions(){
        return transactionRepository.findByUser(userService.getAuthenticatedUser());
    }

    public List<Transaction> getLastTransactions(){
        return transactionRepository.getLastTransactions(userService.getAuthenticatedUser().getId(), new PageRequest(0,6));
    }

    //TODO
    public List<BigDecimal> getAmountForCurrentMonth() {
        String currentMonthDate = ZonedDateTime.now().getMonthValue() + "/" + ZonedDateTime.now().getYear();
        List<Transaction> transactions = transactionRepository.findByDateStringLike(currentMonthDate);
        return null;
    }

    private BankAccount updateBalance(TransactionDTO transactionDTO) {
        String bankAccountSender = transactionDTO.getSendAccount();
        BankAccount bankAccount = bankAccountsRepository.findByUserAndAccountNumber(userService.getAuthenticatedUser(),bankAccountSender);
        bankAccount.setBalance(BigDecimal.valueOf(bankAccount.getBalance().longValue()-transactionDTO.getAmount().longValue()));
        return bankAccount;
    }

}
