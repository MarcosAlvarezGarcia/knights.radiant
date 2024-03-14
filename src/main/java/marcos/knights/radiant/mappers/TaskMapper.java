package marcos.knights.radiant.mappers;

import marcos.knights.radiant.dtos.task.TaskRequestDto;
import marcos.knights.radiant.dtos.task.TaskResponseDto;
import marcos.knights.radiant.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskMapper {

    private final MissionMapper missionMapper;

    @Autowired
    public TaskMapper(MissionMapper missionMapper){
        this.missionMapper = missionMapper;
    }

    public TaskResponseDto toResponse(Task task) {
        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getProgress()
                //task.getMission()
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
            //taskRequestDto.getMissionId() != null ?
            //        missionMapper.toModelfromRequestDto(taskRequestDto.getMissionId()) : null
        );
    }
}
