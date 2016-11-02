package ro.cegeka.app.dto;

import lombok.*;
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
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDTO {

    private BigDecimal balance;
    private BigDecimal initialAmount;
    private Currency currency;
}
