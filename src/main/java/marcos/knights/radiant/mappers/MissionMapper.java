package marcos.knights.radiant.mappers;

import marcos.knights.radiant.dtos.mission.MissionRequestDto;
import marcos.knights.radiant.dtos.mission.MissionResponseDto;
import marcos.knights.radiant.models.Mission;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MissionMapper {

    public MissionResponseDto toResponse(Mission mission) {
        return new MissionResponseDto(
                mission.getId(),
                mission.getTitle(),
                mission.getDescription(),
                mission.getTasks(),
                mission.getSeverity(),
                mission.getDifficulty(),
                mission.getEstimatedTime(),
                mission.getActive(),
                mission.getDone()
        );
    }

    public List<MissionResponseDto> toResponse(List<Mission> mission) {
        return mission.stream()
                .map(this::toResponse)
                .toList();
    }

    // Mapeamos de DTO a modelo
    public Mission toModel(MissionRequestDto missionRequestDto) {
        return new Mission(
            0L,
            missionRequestDto.getTitle(),
            missionRequestDto.getDescription(),
            missionRequestDto.getTasks(),
            missionRequestDto.getSeverity(),
            missionRequestDto.getDifficulty(),
            missionRequestDto.getEstimatedTime(),
            missionRequestDto.getActive(),
            missionRequestDto.getDone()
        );
    }
}
