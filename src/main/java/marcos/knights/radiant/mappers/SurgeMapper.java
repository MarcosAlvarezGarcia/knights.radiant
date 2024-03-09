package marcos.knights.radiant.mappers;

import marcos.knights.radiant.dtos.surge.SurgeRequestDto;
import marcos.knights.radiant.dtos.surge.SurgeResponseDto;
import marcos.knights.radiant.models.Surge;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SurgeMapper {

    public SurgeResponseDto toResponse(Surge surge) {
        return new SurgeResponseDto(
                surge.getId(),
                surge.getName(),
                surge.getDescription(),
                surge.getRole()
        );
    }

    public List<SurgeResponseDto> toResponse(List<Surge> surge) {
        return surge.stream()
                .map(this::toResponse)
                .toList();
    }

    // Mapeamos de DTO a modelo
    public Surge toModel(SurgeRequestDto surgeRequestDto) {
        return new Surge(
            0L,
            surgeRequestDto.getName(),
            surgeRequestDto.getDescription(),
            surgeRequestDto.getRole()
        );
    }
}
