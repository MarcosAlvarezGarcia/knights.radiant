package marcos.knights.radiant.services.task;

import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.models.Mission;
import marcos.knights.radiant.models.Task;
import marcos.knights.radiant.repositories.MissionRepository;
import marcos.knights.radiant.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final MissionRepository missionRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, MissionRepository missionRepository) {
        this.taskRepository = taskRepository;
        this.missionRepository = missionRepository;
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
        Task updated = this.findById(id);
        updated.setProgress(progress);
        return taskRepository.save(updated);
    }

    @Override
    public Task update(Long id, Task task) {

        Task updated = this.findById(id);
        Mission mission = null;

        // Si me pasan la misión es porque debe existir
        //if (task.getMission() != null) {
        //    mission = missionRepository.findById(task.getMission().getId()).orElseThrow();
        //}

        // Actualizamos los datos
        updated.setTitle(task.getTitle());
        updated.setDescription(task.getDescription());
        updated.setProgress(task.getProgress());
        //updated.setMission(mission);

        // Guardamos los cambios
        return taskRepository.save(updated);
    }
}
