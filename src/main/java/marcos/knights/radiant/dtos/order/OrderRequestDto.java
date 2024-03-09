package marcos.knights.radiant.dtos.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Surge;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderRequestDto {
    private final String name;
    private final String sprenType;
    private final String description;
    private final String attributes;
    private final List<Surge> surges;
}
