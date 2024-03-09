package marcos.knights.radiant.services.task;

import marcos.knights.radiant.models.Task;

import java.util.List;

public interface TaskService {
    void deleteById(Long id);
    List<Task> findAll();
    Task findById(Long id);
    Task save(Task task);
    Task setProgress(Long id, Long progress);
    Task update(Long id, Task task);
}