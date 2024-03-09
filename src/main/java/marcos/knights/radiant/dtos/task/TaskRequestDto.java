package marcos.knights.radiant.dtos.task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskRequestDto {
    private final String title;
    private final String description;
    private final Long progress;
}
