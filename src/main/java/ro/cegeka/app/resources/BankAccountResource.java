package ro.cegeka.app.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.cegeka.app.domain.model.BankAccount;
import ro.cegeka.app.dto.BankAccountDTO;
import ro.cegeka.app.services.BankAccountService;
import ro.cegeka.app.services.UserService;

@RestController
@RequestMapping("api/bank-accounts")
public class BankAccountResource {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<BankAccount>> getBankAccountsByUser(@RequestParam("page") Integer page,
                                                                   @RequestParam("limit") Integer limit,
                                                                   @RequestParam("order") String order) {
        return new ResponseEntity<>(bankAccountService.getBankAccountsByUser(page, limit, order), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBankAccount(@RequestBody BankAccountDTO bankAccountDto) {
        bankAccountService.saveBankAccount(bankAccountDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{account_id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAccount(@PathVariable("account_id") Long id) {
        bankAccountService.deleteAccount(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
