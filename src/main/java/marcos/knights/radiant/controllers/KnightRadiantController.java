package marcos.knights.radiant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.dtos.knightRadiant.KnightRadiantRequestDto;
import marcos.knights.radiant.dtos.knightRadiant.KnightRadiantResponseDto;
import marcos.knights.radiant.dtos.task.TaskResponseDto;
import marcos.knights.radiant.mappers.KnightRadiantMapper;
import marcos.knights.radiant.models.Ideal;
import marcos.knights.radiant.models.KnightRadiant;
import marcos.knights.radiant.models.Role;
import marcos.knights.radiant.models.User;
import marcos.knights.radiant.services.knightRadiant.KnightRadiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knightsRadiant/knightRadiant")
@CrossOrigin (origins = "http://localhost:4200")
@RequiredArgsConstructor
@Slf4j
public class KnightRadiantController {

    private final KnightRadiantService knightRadiantService;
    private final KnightRadiantMapper knightRadiantMapper;

    @DeleteMapping("delete/{id}")
    public ResponseEntity<KnightRadiantResponseDto> deleteKnightRadiant(
            @PathVariable Long id
    ) {
        log.info("deleteKnightRadiant");
        knightRadiantService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<KnightRadiantResponseDto>> getAllKnightRadiants(
    ) {
        log.info("getAllKnightRadiants");
        return ResponseEntity.ok(knightRadiantMapper.toResponse(knightRadiantService.findAll()));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<KnightRadiantResponseDto> getKnightRadiantById(
            @PathVariable Long id
    ) {
        log.info("getKnightRadiantById");
        return ResponseEntity.ok(knightRadiantMapper.toResponse(knightRadiantService.findById(id)));
    }

    @PatchMapping("/setCurrentMissionId/{id}")
    public ResponseEntity<KnightRadiantResponseDto> setCurrentMissionId(
            @PathVariable Long id,
            @RequestParam Long currentMissionId
    ) {
        log.info("setCurrentMissionId");
        return ResponseEntity.ok(knightRadiantMapper.toResponse(knightRadiantService.setCurrentMissionId(id, currentMissionId)));
    }

    @PatchMapping("/setCurrentMissionIdToNull/{id}")
    public ResponseEntity<KnightRadiantResponseDto> setCurrentMissionToNull(
            @PathVariable Long id
    ) {
        log.info("setCurrentMissionToNull");
        return ResponseEntity.ok(knightRadiantMapper.toResponse(knightRadiantService.setCurrentMissionIdToNull(id)));
    }

    @PatchMapping("/setMissionsCompleted/{id}")
    public ResponseEntity<KnightRadiantResponseDto> setMissionsCompleted(
            @PathVariable Long id
    ) {
        log.info("setMissionsCompleted");
        return ResponseEntity.ok(knightRadiantMapper.toResponse(knightRadiantService.setMissionsCompleted(id)));
    }

    @PatchMapping("/setRadiantOrder/{id}")
    public ResponseEntity<KnightRadiantResponseDto> setRadiantOrder(
            @PathVariable Long id,
            @RequestParam Long radiantOrderId
    ) {
        log.info("setRadiantOrder");
        return ResponseEntity.ok(knightRadiantMapper.toResponse(knightRadiantService.setRadiantOrder(id, radiantOrderId)));
    }

    @PatchMapping("/setRole/{id}")
    public ResponseEntity<KnightRadiantResponseDto> setRole(
            @PathVariable Long id,
            @RequestParam Ideal ideal
    ) {
        log.info("setRadiantOrder");
        return ResponseEntity.ok(knightRadiantMapper.toResponse(knightRadiantService.setIdeal(id, ideal)));
    }

    @PostMapping("/create")
    public ResponseEntity<KnightRadiantResponseDto> postKnightRadiant(
            @RequestBody KnightRadiantRequestDto knightRadiantRequestDto
    ) {
        log.info("addKnightRadiant");
        KnightRadiant knightRadiantSaved = knightRadiantService.save(knightRadiantMapper.toModel(knightRadiantRequestDto));
        return ResponseEntity.created(null).body(knightRadiantMapper.toResponse(knightRadiantSaved));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<KnightRadiantResponseDto> putKnightRadiant(
            @PathVariable Long id,
            @RequestBody KnightRadiantRequestDto knightRadiantRequestDto
    ) {
        log.info("putKnightRadiant");
        KnightRadiant knightRadiantUpdated = knightRadiantService.update(id, knightRadiantMapper.toModel(knightRadiantRequestDto));
        return ResponseEntity.ok(knightRadiantMapper.toResponse(knightRadiantUpdated));
    }

}