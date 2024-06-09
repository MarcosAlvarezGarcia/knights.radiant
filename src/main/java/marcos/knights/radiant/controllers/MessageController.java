package marcos.knights.radiant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.dtos.message.MessageRequestDto;
import marcos.knights.radiant.dtos.message.MessageResponseDto;
import marcos.knights.radiant.mappers.MessageMapper;
import marcos.knights.radiant.models.Message;
import marcos.knights.radiant.models.User;
import marcos.knights.radiant.services.message.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knightsRadiant/messages")
@CrossOrigin (origins = "http://localhost:4200")
@RequiredArgsConstructor
@Slf4j
public class MessageController {

    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @DeleteMapping("delete/{id}")
    public ResponseEntity<MessageResponseDto> deleteMessage(
            @PathVariable Long id
    ) {
        log.info("deleteMessage");
        messageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<MessageResponseDto>> getAllMessages(
    ) {
        log.info("getAllMessages");
        return ResponseEntity.ok(messageMapper.toResponse(messageService.findAll()));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<MessageResponseDto> getMessageById(
            @PathVariable Long id
    ) {
        log.info("getMessageById");
        return ResponseEntity.ok(messageMapper.toResponse(messageService.findById(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<MessageResponseDto> postMessage(
            @AuthenticationPrincipal User user,
            @RequestBody MessageRequestDto messageRequestDto
    ) {
        log.info("addMessage");
        Long userId = user.getId();
        MessageRequestDto dtoWithUserId = new MessageRequestDto(userId, messageRequestDto.getTitle(), messageRequestDto.getContent());
        Message messageSaved = messageService.save(messageMapper.toModel(dtoWithUserId));
        return ResponseEntity.created(null).body(messageMapper.toResponse(messageSaved));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<MessageResponseDto> putMessage(
            @PathVariable Long id,
            @RequestBody MessageRequestDto messageRequestDto
    ) {
        log.info("putMessage");
        Message messageUpdated = messageService.update(id, messageMapper.toModel(messageRequestDto));
        return ResponseEntity.ok(messageMapper.toResponse(messageUpdated));
    }

}