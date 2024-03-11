package marcos.knights.radiant.services.mission;

import marcos.knights.radiant.models.Mission;

import java.util.List;

public interface MissionService {
    void deleteById(Long id);
    List<Mission> findAll();
    Mission findById(Long id);
    List<Mission> findByTitle(String title);
    Mission save(Mission mission);
    Mission setActive(Long id, Boolean active);
    Mission setDone(Long id, Boolean done);
    Mission update(Long id, Mission mission);
}