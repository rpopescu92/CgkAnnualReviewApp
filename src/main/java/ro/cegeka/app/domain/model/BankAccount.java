package ro.cegeka.app.domain.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by roxanap on 16.10.2016.
 */
@Entity
@Table(name = "Accounts")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    @ManyToOne
    private User user;
    private BigDecimal balance;

}
