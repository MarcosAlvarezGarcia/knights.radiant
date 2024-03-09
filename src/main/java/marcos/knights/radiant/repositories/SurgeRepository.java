package marcos.knights.radiant.repositories;

import marcos.knights.radiant.models.Surge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurgeRepository extends JpaRepository<Surge, Long> {
    List<Surge> findSurgeByNameContainsIgnoreCase(String name);
}
