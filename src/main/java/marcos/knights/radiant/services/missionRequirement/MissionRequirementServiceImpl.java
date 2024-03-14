package marcos.knights.radiant.services.missionRequirement;

import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.models.MissionRequirement;
import marcos.knights.radiant.models.Task;
import marcos.knights.radiant.repositories.MissionRequirementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MissionRequirementServiceImpl implements MissionRequirementService {

    private final MissionRequirementRepository missionRequirementRepository;

    public MissionRequirementServiceImpl(MissionRequirementRepository missionRequirementRepository) {
        this.missionRequirementRepository = missionRequirementRepository;
    }

    @Override
    public void deleteById(Long id) {
        missionRequirementRepository.deleteById(id);
    }

    @Override
    public List<MissionRequirement> findAll() {
        return missionRequirementRepository.findAll();
    }

    @Override
    public MissionRequirement findById(Long id) {
        return missionRequirementRepository.findById(id).orElseThrow();
    }

    @Override
    public MissionRequirement save(MissionRequirement missionRequirement) {
        return missionRequirementRepository.save(missionRequirement);
    }

    @Override
    public MissionRequirement setCurrentAmount(Long id, Long currentAmount) {
        MissionRequirement updated = this.findById(id);
        updated.setCurrentAmount(currentAmount);
        return missionRequirementRepository.save(updated);
    }

    @Override
    public MissionRequirement update(Long id, MissionRequirement missionRequirement) {

        MissionRequirement updated = this.findById(id);

        // Actualizamos los datos
        updated.setRequirement(missionRequirement.getRequirement());
        updated.setRequiredAmount(missionRequirement.getRequiredAmount());
        updated.setCurrentAmount(missionRequirement.getCurrentAmount());


        // Guardamos los cambios
        return missionRequirementRepository.save(updated);
    }
}
