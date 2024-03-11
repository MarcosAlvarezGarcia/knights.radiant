package marcos.knights.radiant.repositories;

import marcos.knights.radiant.models.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    List<Mission> findMissionsByTitleContainsIgnoreCase(String title);
}
