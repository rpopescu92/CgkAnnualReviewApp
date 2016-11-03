package ro.cegeka.app.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.spi.LoadState;
import java.math.BigDecimal;

/**
 * Created by roxanap on 03.11.2016.
 */
@Entity
@Table(name = "Transaction")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;
    private BigDecimal amount;

    @ManyToOne
    private BankAccount sendAccount;

    private String destinationAccount;

    private String date;
}
