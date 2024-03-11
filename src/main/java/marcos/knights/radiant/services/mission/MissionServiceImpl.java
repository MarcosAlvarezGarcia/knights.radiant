package marcos.knights.radiant.services.mission;

import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.models.Mission;
import marcos.knights.radiant.models.Task;
import marcos.knights.radiant.repositories.MissionRepository;
import marcos.knights.radiant.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final TaskRepository taskRepository;

    public MissionServiceImpl(MissionRepository missionRepository, TaskRepository taskRepository) {
        this.missionRepository = missionRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public Mission addTaskToMission(Long id, Long taskId) {
        Mission missionUpdated = this.findById(id);
        Task newTask = taskRepository.findById(taskId).orElseThrow();
        List<Task> tasks = missionUpdated.getTasks();
        tasks.add(newTask);
        missionUpdated.setTasks(tasks);
        return missionRepository.save(missionUpdated);
    }

    @Override
    public void deleteById(Long id) {
        missionRepository.deleteById(id);
    }

    @Override
    public List<Mission> findAll() {
        return missionRepository.findAll();
    }

    @Override
    public Mission findById(Long id) {
        return missionRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Mission> findByTitle(String name) {
        return missionRepository.findMissionsByTitleContainsIgnoreCase(name);
    }

    @Override
    public Mission save(Mission mission) {
        return missionRepository.save(mission);
    }

    @Override
    public Mission setActive(Long id, Boolean active) {
        Mission updated = this.findById(id);

        updated.setActive(active);
        return missionRepository.save(updated);
    }

    @Override
    public Mission setDone(Long id, Boolean done) {
        Mission updated = this.findById(id);

        updated.setDone(done);
        return missionRepository.save(updated);
    }

    @Override
    public Mission update(Long id, Mission mission) {

        Mission updated = this.findById(id);

        // Actualizamos los datos
        updated.setTitle(mission.getTitle());
        updated.setDescription(mission.getDescription());
        updated.setTasks(mission.getTasks());
        updated.setSeverity(mission.getSeverity());
        updated.setDifficulty(mission.getDifficulty());
        updated.setEstimatedTime(mission.getEstimatedTime());
        updated.setActive(mission.getActive());
        updated.setDone(mission.getDone());

        // Guardamos los cambios
        return missionRepository.save(updated);
    }
}
