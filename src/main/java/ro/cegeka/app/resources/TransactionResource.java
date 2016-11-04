package ro.cegeka.app.resources;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.cegeka.app.domain.model.Transaction;
import ro.cegeka.app.dto.TransactionDTO;
import ro.cegeka.app.services.TransactionService;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by roxanap on 03.11.2016.
 */
@RestController
@RequestMapping("api/transactions")
public class TransactionResource {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO){
        try{
            transactionService.createTransaction(transactionDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getLastTransactions() {
        return new ResponseEntity<>(transactionService.getLastTransactions(),HttpStatus.OK);
    }

    @RequestMapping(value="/current-month", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getCurrentMonthTransactions() {
        return new ResponseEntity<>(transactionService.getAmountForCurrentMonth(), HttpStatus.OK);
    }

    @RequestMapping(value="/months", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getMonths() {
        return new ResponseEntity<>(
                Stream.of(Month.values())
                        .map(Enum::toString)
                        .collect(Collectors.toList()), HttpStatus.OK
        );
    }

    @RequestMapping(value = "/yearly")
    public ResponseEntity<List<BigDecimal>> getAmountForMonths() {
        return new ResponseEntity<>(transactionService.getYearlyTransactionAmount(), HttpStatus.OK);
    }

}
