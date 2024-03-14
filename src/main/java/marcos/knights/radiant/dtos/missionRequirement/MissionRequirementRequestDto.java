package marcos.knights.radiant.dtos.missionRequirement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MissionRequirementRequestDto {
    private final String requirement;
    private final Long requiredAmount;
    private final Long currentAmount;
}
