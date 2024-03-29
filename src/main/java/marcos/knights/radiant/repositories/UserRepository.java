package marcos.knights.radiant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import marcos.knights.radiant.models.Role;
import marcos.knights.radiant.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByRole(Role role);
    Optional<User> findByEmail(String email);
}
