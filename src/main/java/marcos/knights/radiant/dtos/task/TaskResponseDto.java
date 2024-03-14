package marcos.knights.radiant.dtos.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Mission;

@Data
@AllArgsConstructor
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private Long progress;
    //private Mission mission;
}
