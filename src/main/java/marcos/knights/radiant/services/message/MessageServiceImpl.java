package marcos.knights.radiant.services.message;

import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.models.Message;
import marcos.knights.radiant.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id).orElseThrow();
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message update(Long id, Message message) {

        Message updated = this.findById(id);

        // Actualizamos los datos
        updated.setContent(message.getTitle());
        updated.setContent(message.getContent());

        // Guardamos los cambios
        return messageRepository.save(updated);
    }
}
