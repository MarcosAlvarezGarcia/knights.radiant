package marcos.knights.radiant.mappers;

import marcos.knights.radiant.dtos.order.OrderRequestDto;
import marcos.knights.radiant.dtos.order.OrderResponseDto;
import marcos.knights.radiant.models.RadiantOrder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    public OrderResponseDto toResponse(RadiantOrder radiantOrder) {
        return new OrderResponseDto(
                radiantOrder.getId(),
                radiantOrder.getName(),
                radiantOrder.getSprenType(),
                radiantOrder.getDescription(),
                radiantOrder.getAttributes(),
                radiantOrder.getSurges()
        );
    }

    public List<OrderResponseDto> toResponse(List<RadiantOrder> radiantOrder) {
        return radiantOrder.stream()
                .map(this::toResponse)
                .toList();
    }

    // Mapeamos de DTO a modelo
    public RadiantOrder toModel(OrderRequestDto orderRequestDto) {
        return new RadiantOrder(
            0L,
            orderRequestDto.getName(),
            orderRequestDto.getSprenType(),
            orderRequestDto.getDescription(),
            orderRequestDto.getAttributes(),
            orderRequestDto.getSurges()
        );
    }
}
