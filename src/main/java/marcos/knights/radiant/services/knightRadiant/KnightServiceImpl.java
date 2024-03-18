package marcos.knights.radiant.services.knightRadiant;

import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.errors.UserException;
import marcos.knights.radiant.models.*;
import marcos.knights.radiant.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class KnightServiceImpl implements KnightRadiantService {

    private final KnightRadiantRepository knightRadiantRepository;
    private final RadiantOrderRepository radiantOrderRepository;

    public KnightServiceImpl(KnightRadiantRepository knightRadiantRepository, RadiantOrderRepository radiantOrderRepository) {
        this.knightRadiantRepository = knightRadiantRepository;

        this.radiantOrderRepository = radiantOrderRepository;
    }

    @Override
    public void deleteById(Long id) {
        knightRadiantRepository.deleteById(id);
    }

    @Override
    public List<KnightRadiant> findAll() {
        return knightRadiantRepository.findAll();
    }

    @Override
    public KnightRadiant findById(Long id) {
        return knightRadiantRepository.findById(id).orElseThrow();
    }

    @Override
    public KnightRadiant setCurrentMissionId(Long id, Long currentMissionId) {
        KnightRadiant updated = this.findById(id);
        updated.setCurrentMissionId(currentMissionId);
        return knightRadiantRepository.save(updated);
    }

    @Override
    public KnightRadiant setCurrentMissionIdToNull(Long id) {
        KnightRadiant updated = this.findById(id);
        updated.setCurrentMissionId(null);
        return knightRadiantRepository.save(updated);
    }

    @Override
    public KnightRadiant setMissionsCompleted(Long id) {
        KnightRadiant updated = this.findById(id);
        updated.setMissionsCompleted(updated.getMissionsCompleted()+1);
        return knightRadiantRepository.save(updated);
    }

    @Override
    public KnightRadiant setRadiantOrder(Long id, Long radiantOrderId) {
        KnightRadiant updated = this.findById(id);
        RadiantOrder radiantOrder = radiantOrderRepository.findById(radiantOrderId).orElseThrow();
        updated.setRadiantOrder(radiantOrder);
        return knightRadiantRepository.save(updated);
    }

    @Override
    public KnightRadiant setIdeal(Long id, Ideal ideal) {
        KnightRadiant updated = this.findById(id);
        updated.setIdeal(ideal);
        return knightRadiantRepository.save(updated);
    }

    @Override
    public KnightRadiant save(KnightRadiant knightRadiant) {
        return knightRadiantRepository.save(knightRadiant);
    }

    @Override
    public KnightRadiant update(Long id, KnightRadiant knightRadiant) {

        KnightRadiant updated = this.findById(id);

        // Actualizamos los datos
        updated.setIdeal(knightRadiant.getIdeal());
        updated.setCurrentMissionId(knightRadiant.getCurrentMissionId());
        updated.setMissionsCompleted(knightRadiant.getMissionsCompleted());
        updated.setRadiantOrder(knightRadiant.getRadiantOrder());


        // Guardamos los cambios
        return knightRadiantRepository.save(updated);
    }
}
