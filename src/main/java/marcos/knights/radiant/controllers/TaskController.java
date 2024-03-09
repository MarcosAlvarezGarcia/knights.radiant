package marcos.knights.radiant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.dtos.task.TaskRequestDto;
import marcos.knights.radiant.dtos.task.TaskResponseDto;
import marcos.knights.radiant.mappers.TaskMapper;
import marcos.knights.radiant.models.Task;
import marcos.knights.radiant.services.task.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knightsRadiant/tasks")
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @DeleteMapping("delete/{id}")
    public ResponseEntity<TaskResponseDto> deleteTask(
            @PathVariable Long id
    ) {
        log.info("deleteTask");
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<TaskResponseDto>> getAllTasks(
    ) {
        log.info("getAllTasks");
        return ResponseEntity.ok(taskMapper.toResponse(taskService.findAll()));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(
            @PathVariable Long id
    ) {
        log.info("getTaskById");
        return ResponseEntity.ok(taskMapper.toResponse(taskService.findById(id)));
    }

    @PatchMapping("/setProgress/{id}")
    public ResponseEntity<TaskResponseDto> setTaskProgress(
            @PathVariable Long id,
            @RequestParam Long progress
    ) {
        log.info("setBooKClassification");
        return ResponseEntity.ok(taskMapper.toResponse(taskService.setProgress(id, progress)));
    }

    @PostMapping("/create")
    public ResponseEntity<TaskResponseDto> postTask(
            @RequestBody TaskRequestDto taskRequestDto
    ) {
        log.info("addTask");
        Task taskSaved = taskService.save(taskMapper.toModel(taskRequestDto));
        return ResponseEntity.created(null).body(taskMapper.toResponse(taskSaved));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<TaskResponseDto> putTask(
            @PathVariable Long id,
            @RequestBody TaskRequestDto taskRequestDto
    ) {
        log.info("putTask");
        Task taskUpdated = taskService.update(id, taskMapper.toModel(taskRequestDto));
        return ResponseEntity.ok(taskMapper.toResponse(taskUpdated));
    }

}