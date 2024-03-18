package marcos.knights.radiant.dtos.knightRadiant;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Ideal;
import marcos.knights.radiant.models.RadiantOrder;

@Data
@AllArgsConstructor
public class KnightRadiantResponseDto {
    private final Long id;
    private Ideal ideal;
    private Long currentMissionId;
    private Long missionsCompleted;
    private RadiantOrder radiantOrder;
}
