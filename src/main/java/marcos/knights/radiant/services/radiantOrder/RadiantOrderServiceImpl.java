package marcos.knights.radiant.services.radiantOrder;

import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.models.RadiantOrder;
import marcos.knights.radiant.repositories.RadiantOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RadiantOrderServiceImpl implements RadiantOrderService {

    private final RadiantOrderRepository radiantOrderRepository;

    @Autowired
    public RadiantOrderServiceImpl(RadiantOrderRepository radiantOrderRepository) {
        this.radiantOrderRepository = radiantOrderRepository;
    }

    @Override
    public void deleteById(Long id) {
        radiantOrderRepository.deleteById(id);
    }

    @Override
    public List<RadiantOrder> findAll() {
        return radiantOrderRepository.findAll();
    }

    @Override
    public RadiantOrder findById(Long id) {
        return radiantOrderRepository.findById(id).orElseThrow();
    }

    @Override
    public List<RadiantOrder> findByName(String name) {
        return radiantOrderRepository.findOrdersByNameContainsIgnoreCase(name);
    }

    @Override
    public RadiantOrder save(RadiantOrder radiantOrder) {
        return radiantOrderRepository.save(radiantOrder);
    }

    @Override
    public RadiantOrder update(Long id, RadiantOrder radiantOrder) {

        RadiantOrder updated = this.findById(id);

        // Actualizamos los datos
        updated.setName(radiantOrder.getName());
        updated.setSprenType(radiantOrder.getSprenType());
        updated.setDescription(radiantOrder.getDescription());
        updated.setAttributes(radiantOrder.getAttributes());
        updated.setSurges(radiantOrder.getSurges());

        // Guardamos los cambios
        return radiantOrderRepository.save(updated);
    }
}
