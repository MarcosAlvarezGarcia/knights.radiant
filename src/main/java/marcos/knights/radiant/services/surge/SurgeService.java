package marcos.knights.radiant.services.surge;

import marcos.knights.radiant.models.Surge;

import java.util.List;

public interface SurgeService {
    void deleteById(Long id);
    List<Surge> findAll();
    Surge findById(Long id);
    List<Surge> findByName(String name);
    Surge save(Surge surge);
    Surge update(Long id, Surge surge);
}