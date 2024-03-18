package marcos.knights.radiant.services.knightRadiant;

import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.errors.UserException;
import marcos.knights.radiant.models.KnightRadiant;
import marcos.knights.radiant.models.RadiantOrder;
import marcos.knights.radiant.models.Task;
import marcos.knights.radiant.models.User;
import marcos.knights.radiant.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class KnightServiceImpl implements KnightRadiantService {

    private final KnightRadiantRepository knightRadiantRepository;
    private final TaskRepository taskRepository;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final RadiantOrderRepository radiantOrderRepository;

    public KnightServiceImpl(KnightRadiantRepository knightRadiantRepository, TaskRepository taskRepository, MessageRepository messageRepository, UserRepository userRepository, RadiantOrderRepository radiantOrderRepository) {
        this.knightRadiantRepository = knightRadiantRepository;
        this.taskRepository = taskRepository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.radiantOrderRepository = radiantOrderRepository;
    }

    @Override
    public void deleteById(Long id) {
        knightRadiantRepository.deleteById(id);
    }

    @Override
    public List<KnightRadiant> findAll() {
        return knightRadiantRepository.findAll();
    }

    @Override
    public KnightRadiant findById(Long id) {
        return knightRadiantRepository.findById(id).orElseThrow();
    }

    @Override
    public KnightRadiant setCurrentMissionId(Long id, Long currentMissionId) {
        KnightRadiant updated = this.findById(id);
        updated.setCurrentMissionId(currentMissionId);
        return knightRadiantRepository.save(updated);
    }

    @Override
    public KnightRadiant setCurrentMissionIdToNull(Long id) {
        KnightRadiant updated = this.findById(id);
        updated.setCurrentMissionId(null);
        return knightRadiantRepository.save(updated);
    }

    @Override
    public KnightRadiant setMissionsCompleted(Long id) {
        KnightRadiant updated = this.findById(id);
        updated.setMissionsCompleted(updated.getMissionsCompleted()+1);
        return knightRadiantRepository.save(updated);
    }

    @Override
    public KnightRadiant setRadiantOrder(Long id, Long radiantOrderId) {
        KnightRadiant updated = this.findById(id);
        RadiantOrder radiantOrder = radiantOrderRepository.findById(radiantOrderId).orElseThrow();
        updated.setRadiantOrder(radiantOrder);
        return knightRadiantRepository.save(updated);
    }

    @Override
    public KnightRadiant setUserId(Long id, Long userId) {
        KnightRadiant updated = this.findById(id);
        User user = userRepository.findById(id).orElseThrow(() -> new UserException.UserNotFoundException(
                "User with ID " + id + " not found."));
        updated.setUser(user);
        return knightRadiantRepository.save(updated);
    }

    @Override
    public KnightRadiant save(KnightRadiant knightRadiant) {
        return knightRadiantRepository.save(knightRadiant);
    }

    @Override
    public KnightRadiant update(Long id, KnightRadiant knightRadiant) {

        KnightRadiant updated = this.findById(id);

        // Actualizamos los datos
        updated.setRole(knightRadiant.getRole());
        updated.setCurrentMissionId(knightRadiant.getCurrentMissionId());
        updated.setMissionsCompleted(knightRadiant.getMissionsCompleted());
        updated.setUser(knightRadiant.getUser());
        updated.setRadiantOrder(knightRadiant.getRadiantOrder());


        // Guardamos los cambios
        return knightRadiantRepository.save(updated);
    }
}
