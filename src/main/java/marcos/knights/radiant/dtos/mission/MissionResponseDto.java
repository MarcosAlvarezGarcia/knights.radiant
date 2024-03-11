package marcos.knights.radiant.dtos.mission;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Surge;

import java.util.List;

@Data
@AllArgsConstructor
public class MissionResponseDto {
    private Long id;
    private String title;
    private String description;
    private String severity;
    private String difficulty;
    private String estimatedTime;
    private Boolean active;
    private Boolean done;
}
