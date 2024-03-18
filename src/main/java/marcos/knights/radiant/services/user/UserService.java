package marcos.knights.radiant.services.user;

import marcos.knights.radiant.models.KnightRadiant;
import marcos.knights.radiant.models.RadiantOrder;
import marcos.knights.radiant.services.knightRadiant.KnightRadiantService;
import marcos.knights.radiant.services.radiantOrder.RadiantOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import marcos.knights.radiant.config.jwt.JwtTokenUtils;
import marcos.knights.radiant.dtos.user.*;
import marcos.knights.radiant.errors.UserException;
import marcos.knights.radiant.mappers.UserMapper;
import marcos.knights.radiant.models.Role;
import marcos.knights.radiant.models.User;
import marcos.knights.radiant.repositories.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final JwtTokenUtils tokenUtils;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    private final KnightRadiantService knightRadiantService;

    @Autowired
    public UserService(UserRepository repository, JwtTokenUtils tokenUtils, UserMapper mapper, RadiantOrderService radiantOrderService, KnightRadiantService knightRadiantService) {
        this.repository = repository;
        this.tokenUtils = tokenUtils;
        this.mapper = mapper;
        this.knightRadiantService = knightRadiantService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUserName(username)
                .orElseThrow(() -> new UserException.UserNotFoundException(
                        "User with email " + username + " not found."));
    }

    public UserDtoWithToken register(UserDtoRegister dto) {
        if (!Objects.equals(dto.getPassword(), dto.getRepeatPassword())) {
            throw new UserException.UserBadRequestException(
                    "Password and repeated password do not match.");
        }
        Optional<User> user = repository.findByUserName(dto.getEmail());
        if (user.isPresent()) {
            throw new UserException.UserBadRequestException(
                    "There's already an account linked to this email.");
        }
        Long users = (long) findAllUsers().size();
        KnightRadiant knightRadiant = knightRadiantService.findById(users+1);
        User saved = repository.save(new User(null, dto.getEmail(), encoder.encode(dto.getPassword()), Role.NO_IDEAL, knightRadiant));
        return new UserDtoWithToken(
                mapper.toDto(saved),
                tokenUtils.create(saved)
        );
    }

    public UserDtoWithToken create(UserDtoCreate dto) {
        Optional<User> user = repository.findByUserName(dto.getEmail());
        if (user.isPresent()) {
            throw new UserException.UserBadRequestException(
                    "There's already an account linked to this email.");
        }

        User saved = repository.save(new User(null, dto.getEmail(), encoder.encode(dto.getPassword()), dto.getRole(), null));
        return new UserDtoWithToken(
                mapper.toDto(saved),
                tokenUtils.create(saved)
        );
    }

    public List<UserDto> findAll() {
        return mapper.toDto(repository.findAll());
    }
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public List<UserDto> findUsersByRole(Role role) {
        return mapper.toDto(repository.findAllByRole(role));
    }

    public UserDto findUserByEmail(String email) {
        User user = repository.findByUserName(email)
                .orElseThrow(() -> new UserException.UserNotFoundException(
                        "User with email " + email + " not found."));
        return mapper.toDto(user);
    }

    public UserDto findUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new UserException.UserNotFoundException(
                "User with ID " + id + " not found."));
        return mapper.toDto(user);
    }

    public User save(User user){
        return repository.save(user);
    }

    public UserDto changeUserRole(Long id, Role role) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserException.UserNotFoundException(
                        "User with ID " + id + " not found."));
        user.setRole(role);
        User saved = repository.save(new User(user.getId(), user.getUsername(),
                        encoder.encode(user.getPassword()), user.getRole(), user.getKnightRadiant()));
        return mapper.toDto(saved);
    }

    public UserDto updateSelf(Long id, UserDtoUpdate dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserException.UserNotFoundException(
                        "User with ID " + id + " not found."));

        if (!encoder.matches(dto.getPassword(), user.getUserPassword())) {
            throw new UserException.UserBadRequestException(
                    "Incorrect password.");
        }

        User saved = repository.save(new User(user.getId(), user.getUsername(),
                        encoder.encode(dto.getNewPassword()), user.getRole(), user.getKnightRadiant()));
        return mapper.toDto(saved);
    }

    public UserDto update(UserDtoUpdate dto) {
        User user = repository.findByUserName(dto.getEmail())
                .orElseThrow(() -> new UserException.UserNotFoundException(
                        "User with email " + dto.getEmail() + " not found."));

        if (!encoder.matches(dto.getPassword(), user.getUserPassword())) {
            throw new UserException.UserBadRequestException(
                    "Incorrect password.");
        }

        User saved = repository.save(new User(user.getId(), user.getUsername(),
                        encoder.encode(dto.getNewPassword()), user.getRole(), user.getKnightRadiant()));
        return mapper.toDto(saved);
    }

    //TODO: Cambiar a que sea por ID.
    public UserDto delete(String email) {
        User user = repository.findByUserName(email)
                .orElseThrow(() -> new UserException.UserNotFoundException(
                        "User with email " + email + " not found."));

        repository.deleteById(user.getId());
        return mapper.toDto(user);
    }
}
