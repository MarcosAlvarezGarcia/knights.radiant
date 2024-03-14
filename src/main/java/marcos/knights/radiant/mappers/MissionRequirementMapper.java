package marcos.knights.radiant.mappers;

import marcos.knights.radiant.dtos.missionRequirement.MissionRequirementRequestDto;
import marcos.knights.radiant.dtos.missionRequirement.MissionRequirementResponseDto;
import marcos.knights.radiant.models.MissionRequirement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MissionRequirementMapper {

    public MissionRequirementResponseDto toResponse(MissionRequirement missionRequirement) {
        return new MissionRequirementResponseDto(
                missionRequirement.getId(),
                missionRequirement.getRequirement(),
                missionRequirement.getRequiredAmount(),
                missionRequirement.getCurrentAmount()
        );
    }

    public List<MissionRequirementResponseDto> toResponse(List<MissionRequirement> missionRequirement) {
        return missionRequirement.stream()
                .map(this::toResponse)
                .toList();
    }

    // Mapeamos de DTO a modelo
    public MissionRequirement toModel(MissionRequirementRequestDto missionRequirementRequestDto) {
        return new MissionRequirement(
            0L,
            missionRequirementRequestDto.getRequirement(),
            missionRequirementRequestDto.getRequiredAmount(),
            missionRequirementRequestDto.getCurrentAmount()
        );
    }

}
