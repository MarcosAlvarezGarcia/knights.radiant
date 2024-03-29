package marcos.knights.radiant.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marcos.knights.radiant.models.KnightRadiant;
import marcos.knights.radiant.models.RadiantOrder;
import marcos.knights.radiant.models.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Role role;
    private KnightRadiant knightRadiant;
}

