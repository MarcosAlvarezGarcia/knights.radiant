package marcos.knights.radiant.dtos.surge;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Role;

@Data
@AllArgsConstructor
public class SurgeRequestDto {
    private final String name;
    private final String description;
    private final Role role;
}
