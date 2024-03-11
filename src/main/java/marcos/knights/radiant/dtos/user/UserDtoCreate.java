package marcos.knights.radiant.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marcos.knights.radiant.models.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoCreate {
    private String email;
    private String password;
    private Role role;
}