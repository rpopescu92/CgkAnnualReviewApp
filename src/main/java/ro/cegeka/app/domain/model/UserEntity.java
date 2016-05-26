package ro.cegeka.app.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by roxana on 25.05.2016.
 */
@Entity
@Table(name = "user_entity")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private Date createdDate;
}
