package marcos.knights.radiant.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoRegister {
    private String name;
    private String email;
    private String password;
    private String repeatPassword;
}

