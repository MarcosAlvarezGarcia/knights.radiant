package marcos.knights.radiant.mappers;

import marcos.knights.radiant.dtos.message.MessageRequestDto;
import marcos.knights.radiant.dtos.message.MessageResponseDto;
import marcos.knights.radiant.models.Message;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageMapper {

    public MessageResponseDto toResponse(Message message) {
        return new MessageResponseDto(
                message.getId(),
                message.getUserId(),
                message.getTitle(),
                message.getContent()
        );
    }

    public List<MessageResponseDto> toResponse(List<Message> message) {
        return message.stream()
                .map(this::toResponse)
                .toList();
    }

    // Mapeamos de DTO a modelo
    public Message toModel(MessageRequestDto messageRequestDto) {
        return new Message(
            0L,
            messageRequestDto.getUserId(),
            messageRequestDto.getTitle(),
            messageRequestDto.getContent()
        );
    }
}
