package ro.cegeka.app.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ro.cegeka.app.domain.model.Currency;
import ro.cegeka.app.domain.model.User;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created by roxanap on 01.11.2016.
 */
@Builder
@Getter
@Setter
public class BankAccountDTO {

    private String accountNumber;
    private BigDecimal balance;
    private Currency currency;
}
