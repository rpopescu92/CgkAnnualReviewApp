package ro.cegeka.app.resources;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.cegeka.app.domain.model.BankAccount;
import ro.cegeka.app.domain.repository.BankAccountsRepository;
import ro.cegeka.app.dto.BankAccountDTO;
import ro.cegeka.app.services.BankAccountService;
import ro.cegeka.app.services.UserService;

@RestController
@RequestMapping("/accounts")
public class BankAccountResource {
	
	@Autowired
	private BankAccountService bankAccountService;
    @Autowired
    private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<BankAccount> getBankAccountsByUser() {
        return bankAccountService.getAccountsByUser("");
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankAccount> saveBankAccount(@RequestBody BankAccountDTO bankAccountDto){
        try{
            BankAccount bankAccount = BankAccount.builder().accountNumber(bankAccountDto.getAccountNumber())
                                        .balance(BigDecimal.ZERO)
                                        .currency(bankAccountDto.getCurrency())
                                        .user(userService.getAuthenticatedUser())
                                        .build();
            bankAccountService.saveAccount(bankAccount);
            return new ResponseEntity<BankAccount>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<BankAccount>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
