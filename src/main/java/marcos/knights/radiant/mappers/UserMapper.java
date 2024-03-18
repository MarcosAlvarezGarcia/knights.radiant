package marcos.knights.radiant.mappers;

import org.springframework.stereotype.Component;
import marcos.knights.radiant.dtos.user.UserDto;
import marcos.knights.radiant.dtos.user.UserDtoRegister;
import marcos.knights.radiant.models.Role;
import marcos.knights.radiant.models.User;
import marcos.knights.radiant.repositories.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserMapper {
    public User fromDtoRegister(UserDtoRegister dto, UserRepository repository) {
        Optional<User> user = repository.findByUserName(dto.getEmail());
        if (user.isPresent() || !Objects.equals(dto.getPassword(), dto.getRepeatPassword())) {
            return null;
        }
        else return new User(null, dto.getEmail(), dto.getPassword(), Role.KNIGHT_RADIANT, null);
    }

    public UserDto toDto(User entity) {
        return new UserDto(
                entity.getId(),
                entity.getUsername(),
                entity.getRole(),
                entity.getKnightRadiant()
        );
    }

    public List<UserDto> toDto(List<User> entities) {
        return entities.stream().map(this::toDto).toList();
    }

}


