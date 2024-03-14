package marcos.knights.radiant.services.missionRequirement;

import marcos.knights.radiant.models.MissionRequirement;

import java.util.List;

public interface MissionRequirementService {
    void deleteById(Long id);
    List<MissionRequirement> findAll();
    MissionRequirement findById(Long id);
    MissionRequirement save(MissionRequirement missionRequirement);
    MissionRequirement setCurrentAmount(Long id, Long currentAmount);
    MissionRequirement update(Long id, MissionRequirement missionRequirement);
}