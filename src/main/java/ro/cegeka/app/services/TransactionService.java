package ro.cegeka.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cegeka.app.domain.model.Transaction;
import ro.cegeka.app.domain.model.User;
import ro.cegeka.app.domain.repository.TransactionRepository;
import ro.cegeka.app.dto.TransactionDTO;

import java.text.SimpleDateFormat;
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
    private UserService userService;

    public void createTransaction(TransactionDTO transactionDTO){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(new Date());
        Transaction transaction = Transaction.builder().amount(transactionDTO.getAmount())
                                    .date(date)
                                    .sendAccount(transactionDTO.getSendAccount())
                                    .destinationAccount(transactionDTO.getDestinationAccount())
                                    .user(userService.getAuthenticatedUser()).build();
        transactionRepository.save(transaction);
    }

    public Optional<Transaction> getTransactions(){
        return transactionRepository.findByUser(userService.getAuthenticatedUser());
    }

}
