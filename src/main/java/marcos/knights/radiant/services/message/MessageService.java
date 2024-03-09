package marcos.knights.radiant.services.message;

import marcos.knights.radiant.models.Message;

import java.util.List;

public interface MessageService {
    void deleteById(Long id);
    List<Message> findAll();
    Message findById(Long id);
    Message save(Message message);
    Message update(Long id, Message message);
}