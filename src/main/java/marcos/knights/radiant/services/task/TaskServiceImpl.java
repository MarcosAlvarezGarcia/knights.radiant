package marcos.knights.radiant.services.task;

import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.models.Task;
import marcos.knights.radiant.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task setProgress(Long id, Long progress) {
        Task task = this.findById(id);
        task.setProgress(progress);
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, Task task) {

        Task updated = this.findById(id);

        // Actualizamos los datos
        updated.setTitle(task.getTitle());
        updated.setDescription(task.getDescription());
        updated.setProgress(task.getProgress());

        // Guardamos los cambios
        return taskRepository.save(updated);
    }
}
