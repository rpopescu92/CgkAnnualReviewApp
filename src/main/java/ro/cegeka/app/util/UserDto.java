package ro.cegeka.app.util;

import lombok.*;
import ro.cegeka.app.domain.model.User;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private User data;
}
