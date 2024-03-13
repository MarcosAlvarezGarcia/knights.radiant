package marcos.knights.radiant.dtos.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageRequestDto {
    private final Long userId;
    private final String title;
    private final String content;
}
