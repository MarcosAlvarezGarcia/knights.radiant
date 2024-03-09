package marcos.knights.radiant.repositories;

import marcos.knights.radiant.models.RadiantOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RadiantOrderRepository extends JpaRepository<RadiantOrder, Long> {
    List<RadiantOrder> findOrdersByNameContainsIgnoreCase(String name);
}
