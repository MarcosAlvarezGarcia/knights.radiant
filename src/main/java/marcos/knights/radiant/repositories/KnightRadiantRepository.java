package marcos.knights.radiant.repositories;

import marcos.knights.radiant.models.KnightRadiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KnightRadiantRepository extends JpaRepository<KnightRadiant, Long> {
    KnightRadiant findTopByOrderByIdDesc();
    List<KnightRadiant> findByRadiantOrder_Id(Long radiantOrderId);

}
