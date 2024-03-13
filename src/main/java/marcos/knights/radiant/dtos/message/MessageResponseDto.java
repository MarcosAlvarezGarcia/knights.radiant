package marcos.knights.radiant.dtos.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import marcos.knights.radiant.models.Surge;

import java.util.List;

@Data
@AllArgsConstructor
public class MessageResponseDto {
    private Long id;
    private Long userId;
    private String title;
    private String content;
}
