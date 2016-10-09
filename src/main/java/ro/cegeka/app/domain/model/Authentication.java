package ro.cegeka.app.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by roxanap on 05.10.2016.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Authentication implements Serializable{

    @NotNull
    @JsonProperty("user_name")
    private String userName;

    @NotNull
    @JsonProperty("password")
    private String password;

    @NotNull
    @JsonProperty("remember_me")
    private boolean rememberMe = false;

    public Authentication(String userName, String password) {
        setUserName(userName);
        setPassword(password);
    }
}
