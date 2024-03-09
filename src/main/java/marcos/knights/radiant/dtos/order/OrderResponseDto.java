package marcos.knights.radiant.dtos.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Surge;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderResponseDto {
    private Long id;
    private String name;
    private String sprenType;
    private String description;
    private String attributes;
    private List<Surge> surges;
}
