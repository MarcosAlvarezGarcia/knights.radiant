package marcos.knights.radiant.mappers;

import marcos.knights.radiant.dtos.task.TaskRequestDto;
import marcos.knights.radiant.dtos.task.TaskResponseDto;
import marcos.knights.radiant.models.Task;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskMapper {

    public TaskResponseDto toResponse(Task task) {
        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getProgress()
        );
    }

    public List<TaskResponseDto> toResponse(List<Task> task) {
        return task.stream()
                .map(this::toResponse)
                .toList();
    }

    // Mapeamos de DTO a modelo
    public Task toModel(TaskRequestDto taskRequestDto) {
        return new Task(
            0L,
            taskRequestDto.getTitle(),
            taskRequestDto.getDescription(),
            taskRequestDto.getProgress()
        );
    }
}
