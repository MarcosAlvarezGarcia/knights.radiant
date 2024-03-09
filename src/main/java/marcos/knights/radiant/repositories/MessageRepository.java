package marcos.knights.radiant.repositories;

import marcos.knights.radiant.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
