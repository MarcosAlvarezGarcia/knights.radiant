package marcos.knights.radiant.dtos.radiantOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Surge;

import java.util.List;

@Data
@AllArgsConstructor
public class RadiantOrderResponseDto {
    private Long id;
    private String name;
    private String herald;
    private String archetype;
    private String gemstone;
    private String sprenType;
    private String attributes;
    private String color;
    private String oathTheme;
    private String description;
    private String logo;
    private String glyph;
    private List<Surge> surges;
}
