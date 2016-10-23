package ro.cegeka.app.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.cegeka.app.domain.model.BankAccount;
import ro.cegeka.app.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService; 
	
	@RequestMapping(method = RequestMethod.GET)
    public List<BankAccount> getAccountsByUser() {
        return accountService.getAccountsByUser("");        
    }

}
