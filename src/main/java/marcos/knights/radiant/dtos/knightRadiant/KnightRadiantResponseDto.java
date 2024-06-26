package marcos.knights.radiant.dtos.knightRadiant;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Ideal;
import marcos.knights.radiant.models.RadiantOrder;

@Data
@AllArgsConstructor
public class KnightRadiantResponseDto {
    private final Long id;
    private Long ideal;
    private String firstIdeal;
    private String secondIdeal;
    private String thirdIdeal;
    private String fourthIdeal;
    private String fifthIdeal;
    private Long currentMissionId;
    private Long missionsCompleted;
    private RadiantOrder radiantOrder;
}
