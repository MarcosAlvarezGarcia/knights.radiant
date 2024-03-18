package marcos.knights.radiant.dtos.knightRadiant;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.RadiantOrder;
import marcos.knights.radiant.models.Role;
import marcos.knights.radiant.models.User;

@Data
@AllArgsConstructor
public class KnightRadiantResponseDto {
    private final Long id;
    private Role role;
    private Long currentMissionId;
    private Long missionsCompleted;
    private RadiantOrder radiantOrder;
}
