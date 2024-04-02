package marcos.knights.radiant.dtos.radiantOrder;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Surge;

import java.util.List;

@Data
@AllArgsConstructor
public class RadiantOrderRequestDto {
    private final String name;
    private final String herald;
    private final String archetype;
    private final String gemstone;
    private final String sprenType;
    private final String attributes;
    private final String color;
    private final String oathTheme;
    private final String description;
    private final String logo;
    private final String glyph;
    private final List<Surge> surges;
}
