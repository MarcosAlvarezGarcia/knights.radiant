package marcos.knights.radiant.mappers;

import marcos.knights.radiant.dtos.knightRadiant.KnightRadiantRequestDto;
import marcos.knights.radiant.dtos.knightRadiant.KnightRadiantResponseDto;
import marcos.knights.radiant.models.KnightRadiant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KnightRadiantMapper {
    public KnightRadiantResponseDto toResponse(KnightRadiant knightRadiant) {
        return new KnightRadiantResponseDto(
                knightRadiant.getId(),
                knightRadiant.getIdeal(),
                knightRadiant.getCurrentMissionId(),
                knightRadiant.getMissionsCompleted(),
                knightRadiant.getRadiantOrder()
        );
    }

    public List<KnightRadiantResponseDto> toResponse(List<KnightRadiant> knightRadiant) {
        return knightRadiant.stream()
                .map(this::toResponse)
                .toList();
    }

    // Mapeamos de DTO a modelo
    public KnightRadiant toModel(KnightRadiantRequestDto knightRadiantRequestDto) {
        return new KnightRadiant(
                0L,
                knightRadiantRequestDto.getIdeal(),
                knightRadiantRequestDto.getCurrentMissionId(),
                0L,
                null
        );
    }
}
