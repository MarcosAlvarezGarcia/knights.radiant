package marcos.knights.radiant.dtos.surge;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Ideal;
import marcos.knights.radiant.models.Role;

@Data
@AllArgsConstructor
public class SurgeResponseDto {
    private Long id;
    private String name;
    private String description;
    private Ideal ideal;
}
