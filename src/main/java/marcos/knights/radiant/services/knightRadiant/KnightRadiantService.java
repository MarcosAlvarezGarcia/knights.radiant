package marcos.knights.radiant.services.knightRadiant;

import marcos.knights.radiant.models.Ideal;
import marcos.knights.radiant.models.KnightRadiant;
import marcos.knights.radiant.models.Role;

import java.util.List;

public interface KnightRadiantService {
    void deleteById(Long id);
    List<KnightRadiant> findAll();
    KnightRadiant findById(Long id);
    KnightRadiant setFirstIdeal(Long id, String firstIdeal);
    KnightRadiant setSecondIdeal(Long id, String secondIdeal);
    KnightRadiant setThirdIdeal(Long id, String thirdIdeal);
    KnightRadiant setFourthIdeal(Long id, String fourthIdeal);
    KnightRadiant setFifthIdeal(Long id, String fifthIdeal);
    KnightRadiant setCurrentMissionId(Long id, Long currentMissionId);
    KnightRadiant setCurrentMissionIdToNull(Long id);
    KnightRadiant setMissionsCompleted(Long id);
    KnightRadiant setRadiantOrder(Long id, Long radiantOrderId);
    KnightRadiant setIdeal(Long id);
    KnightRadiant save(KnightRadiant knightRadiant);
    KnightRadiant update(Long id, KnightRadiant knightRadiant);
}