package marcos.knights.radiant.services.radiantOrder;

import marcos.knights.radiant.models.RadiantOrder;

import java.util.List;

public interface RadiantOrderService {
    void deleteById(Long id);
    List<RadiantOrder> findAll();
    RadiantOrder findById(Long id);
    List<RadiantOrder> findByName(String name);
    RadiantOrder save(RadiantOrder radiantOrder);
    RadiantOrder update(Long id, RadiantOrder radiantOrder);
}