package marcos.knights.radiant.dtos.knightRadiant;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Ideal;

@Data
@AllArgsConstructor
public class KnightRadiantRequestDto {
    private Ideal ideal;
    private String firstIdeal;
    private String secondIdeal;
    private String thirdIdeal;
    private String fourthIdeal;
    private String fifthIdeal;
    private Long currentMissionId;
    private Long missionsCompleted;
}
