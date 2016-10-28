package ro.cegeka.app.domain.model;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by roxana on 25.05.2016.
 */
@Entity
@Table(name = "user")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String userName;
    private String password;
    private Date createdDate;
    private Date birthday;

//    public static void main(String[] args) {
//        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
//        System.out.println(pe.encode("admin"));
//    }
}
