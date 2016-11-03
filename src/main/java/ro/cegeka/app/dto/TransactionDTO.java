package ro.cegeka.app.dto;

import lombok.*;
import ro.cegeka.app.domain.model.BankAccount;
import java.math.BigDecimal;

/**
 * Created by roxanap on 03.11.2016.
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private BigDecimal amount;
    private BankAccount sendAccount;
    private BankAccount destinationAccount;
}
