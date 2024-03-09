package marcos.knights.radiant.services.surge;

import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.models.Surge;
import marcos.knights.radiant.repositories.SurgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SurgeServiceImpl implements SurgeService {

    private final SurgeRepository surgeRepository;

    @Autowired
    public SurgeServiceImpl(SurgeRepository surgeRepository) {
        this.surgeRepository = surgeRepository;
    }

    @Override
    public void deleteById(Long id) {
        surgeRepository.deleteById(id);
    }

    @Override
    public List<Surge> findAll() {
        return surgeRepository.findAll();
    }

    @Override
    public Surge findById(Long id) {
        return surgeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Surge> findByName(String name) {
        return surgeRepository.findSurgeByNameContainsIgnoreCase(name);
    }

    @Override
    public Surge save(Surge surge) {
        return surgeRepository.save(surge);
    }

    @Override
    public Surge update(Long id, Surge surge) {

        Surge updated = this.findById(id);

        // Actualizamos los datos
        updated.setName(surge.getName());
        updated.setDescription(surge.getDescription());
        updated.setRole(surge.getRole());

        // Guardamos los cambios
        return surgeRepository.save(updated);
    }
}
