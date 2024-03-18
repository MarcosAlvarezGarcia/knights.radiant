package marcos.knights.radiant.services.knightRadiant;

import marcos.knights.radiant.models.KnightRadiant;
import marcos.knights.radiant.models.Task;

import java.util.List;

public interface KnightRadiantService {
    void deleteById(Long id);
    List<KnightRadiant> findAll();
    KnightRadiant findById(Long id);
    KnightRadiant setCurrentMissionId(Long id, Long currentMissionId);
    KnightRadiant setCurrentMissionIdToNull(Long id);
    KnightRadiant setMissionsCompleted(Long id);
    KnightRadiant setRadiantOrder(Long id, Long radiantOrderId);
    KnightRadiant setUserId(Long id, Long userId);
    KnightRadiant save(KnightRadiant knightRadiant);
    KnightRadiant update(Long id, KnightRadiant knightRadiant);
}