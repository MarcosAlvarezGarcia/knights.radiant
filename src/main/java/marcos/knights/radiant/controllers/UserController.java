package marcos.knights.radiant.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.dtos.mission.MissionResponseDto;
import marcos.knights.radiant.dtos.task.TaskResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import marcos.knights.radiant.config.jwt.JwtTokenUtils;
import marcos.knights.radiant.dtos.user.*;
import marcos.knights.radiant.errors.UserException;
import marcos.knights.radiant.mappers.UserMapper;
import marcos.knights.radiant.models.Role;
import marcos.knights.radiant.models.User;
import marcos.knights.radiant.services.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/knightsRadiant/users")
@Slf4j
public class UserController {
    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtils jwtTokenUtils;
    private final UserMapper mapper;

    @Autowired public UserController(UserService service, AuthenticationManager authenticationManager, JwtTokenUtils jwtTokenUtils, UserMapper mapper) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtils = jwtTokenUtils;
        this.mapper = mapper;
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<UserDto> delete(
            @PathVariable String email,
            @AuthenticationPrincipal User user
    ) {
        log.info("Deleting");
        return ResponseEntity.ok(service.delete(email));
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> findAll(
            @AuthenticationPrincipal User user,
            @RequestParam @Nullable String role
    ) {
        try {
            if (role != null  && !role.isEmpty()) {
                log.info("find all users by role " + role);
                return ResponseEntity.ok(service.findUsersByRole(Role.valueOf(role)));
            }
            log.info("find all users");
            return ResponseEntity.ok(service.findAll());
        }
        catch (Exception e) {
            throw new UserException.UserBadRequestException(e.getMessage());
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> findByEmail(
            @AuthenticationPrincipal User user,
            @PathVariable String email
    ) {
        log.info("find by email " + email);
        return ResponseEntity.ok(service.findUserByEmail(email));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDto> findById(
            @AuthenticationPrincipal User user,
            @PathVariable Long id
    ) {
        log.info("find by ID " + id);
        return ResponseEntity.ok(service.findUserById(id));
    }

    @PatchMapping("/changeUserRole")
    public ResponseEntity<UserDto> changeUserRole(
            @AuthenticationPrincipal User user,
            @RequestParam Role role
    ) {
        log.info("changeUserRole");
        return ResponseEntity.ok(service.changeUserRole(user.getId(), role));
    }

    @PatchMapping("/setRadiantOrder")
    public ResponseEntity<UserDto> setRadiantOrder(
            @AuthenticationPrincipal User user,
            @RequestParam Long radiantOrderId
    ) {
        log.info("setRadiantOrder");
        return ResponseEntity.ok(service.setRadiantOrder(user.getId(), radiantOrderId));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDtoWithToken> create(
            @AuthenticationPrincipal User user,
            @Valid @RequestBody UserDtoCreate dto
    ) {
        return ResponseEntity.created(null).body(service.create(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDtoWithToken> register(
            @RequestBody UserDtoRegister dto
    ) {
        return ResponseEntity.created(null).body(service.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDtoWithToken> login(@Valid @RequestBody UserDtoLogin dto) {
        //dto.validate();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(new UserDtoWithToken(mapper.toDto(user), jwtTokenUtils.create(user)));
    }

    @PutMapping("/update/me")
    public ResponseEntity<UserDto> updateMySelf(
            @AuthenticationPrincipal User user,
            @Valid @RequestBody UserDtoUpdate dto
    ) {
        log.info("Updating self");
        //dto.validate();
        return ResponseEntity.ok(service.updateSelf(user.getId(), dto));
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> update(
            @AuthenticationPrincipal User user,
            @Valid @RequestBody UserDtoUpdate dto
    ) {
        log.info("Updating");
        //dto.validate();
        return ResponseEntity.ok(service.update(dto));
    }

}