package marcos.knights.radiant.dtos.missionRequirement;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Task;
import marcos.knights.radiant.models.User;

import java.util.List;

@Data
@AllArgsConstructor
public class MissionRequirementResponseDto {
    private final Long id;
    private final String requirement;
    private final Long requiredAmount;
    private Long currentAmount;
}
