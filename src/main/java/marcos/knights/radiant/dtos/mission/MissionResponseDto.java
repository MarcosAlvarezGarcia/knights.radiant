package marcos.knights.radiant.dtos.mission;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Message;
import marcos.knights.radiant.models.Task;

import java.util.List;

@Data
@AllArgsConstructor
public class MissionResponseDto {
    private final Long id;
    private final String title;
    private final String description;
    private final String severity;
    private final String difficulty;
    private final String estimatedTime;
    private final Boolean active;
    private final Boolean done;
    private List<Task> tasks;
    //private final List<Message> messages;
}
