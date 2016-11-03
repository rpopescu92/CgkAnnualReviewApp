package ro.cegeka.app.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.cegeka.app.domain.model.BankAccount;
import ro.cegeka.app.dto.BankAccountDTO;
import ro.cegeka.app.services.BankAccountService;
import ro.cegeka.app.services.UserService;

import java.util.List;

@RestController
@RequestMapping("api/bank-accounts")
public class BankAccountResource {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BankAccount>> getBankAccountsByUser() {
        return new ResponseEntity<>(bankAccountService.getBankAccountsByUser(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBankAccount(@RequestBody BankAccountDTO bankAccountDto) {
        bankAccountService.saveBankAccount(bankAccountDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
