package marcos.knights.radiant.mappers;

import marcos.knights.radiant.dtos.radiantOrder.RadiantOrderRequestDto;
import marcos.knights.radiant.dtos.radiantOrder.RadiantOrderResponseDto;
import marcos.knights.radiant.models.RadiantOrder;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.List;

@Component
public class RadiantOrderMapper {

    public RadiantOrderResponseDto toResponse(RadiantOrder radiantOrder) {
        return new RadiantOrderResponseDto(
                radiantOrder.getId(),
                radiantOrder.getName(),
                radiantOrder.getHerald(),
                radiantOrder.getArchetype(),
                radiantOrder.getGemstone(),
                radiantOrder.getSprenType(),
                radiantOrder.getAttributes(),
                radiantOrder.getColor(),
                radiantOrder.getOathTheme(),
                radiantOrder.getDescription(),
                convertBytesToString(radiantOrder.getLogo()), // Convertir byte[] a String
                convertBytesToString(radiantOrder.getGlyph()),  // Convertir byte[] a String
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
            radiantOrderRequestDto.getHerald(),
            radiantOrderRequestDto.getArchetype(),
            radiantOrderRequestDto.getGemstone(),
            radiantOrderRequestDto.getSprenType(),
            radiantOrderRequestDto.getAttributes(),
            radiantOrderRequestDto.getColor(),
            radiantOrderRequestDto.getOathTheme(),
            radiantOrderRequestDto.getDescription(),
            null,
            null,
            radiantOrderRequestDto.getSurges()
        );
    }

    private String convertBytesToString(byte[] bytes) {
        if (bytes != null && bytes.length > 0) {
            return Base64.getEncoder().encodeToString(bytes);
        }
        return null;
    }


}
