package marcos.knights.radiant.mappers;

import marcos.knights.radiant.dtos.radiantOrder.RadiantOrderRequestDto;
import marcos.knights.radiant.dtos.radiantOrder.RadiantOrderResponseDto;
import marcos.knights.radiant.models.RadiantOrder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RadiantOrderMapper {

    public RadiantOrderResponseDto toResponse(RadiantOrder radiantOrder) {
        return new RadiantOrderResponseDto(
                radiantOrder.getId(),
                radiantOrder.getName(),
                radiantOrder.getSprenType(),
                radiantOrder.getDescription(),
                radiantOrder.getAttributes(),
                radiantOrder.getSurges()
        );
    }

    public List<RadiantOrderResponseDto> toResponse(List<RadiantOrder> radiantOrder) {
        return radiantOrder.stream()
                .map(this::toResponse)
                .toList();
    }

    // Mapeamos de DTO a modelo
    public RadiantOrder toModel(RadiantOrderRequestDto radiantOrderRequestDto) {
        return new RadiantOrder(
            0L,
            radiantOrderRequestDto.getName(),
            radiantOrderRequestDto.getSprenType(),
            radiantOrderRequestDto.getDescription(),
            radiantOrderRequestDto.getAttributes(),
            radiantOrderRequestDto.getSurges()
        );
    }
}
