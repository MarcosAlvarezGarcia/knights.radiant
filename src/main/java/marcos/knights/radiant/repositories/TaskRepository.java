package marcos.knights.radiant.repositories;

import marcos.knights.radiant.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
