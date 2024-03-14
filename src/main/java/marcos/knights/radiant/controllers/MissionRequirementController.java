package marcos.knights.radiant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.dtos.missionRequirement.MissionRequirementRequestDto;
import marcos.knights.radiant.dtos.missionRequirement.MissionRequirementResponseDto;
import marcos.knights.radiant.mappers.MissionRequirementMapper;
import marcos.knights.radiant.models.MissionRequirement;
import marcos.knights.radiant.services.missionRequirement.MissionRequirementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knightsRadiant/missionRequirements")
@RequiredArgsConstructor
@Slf4j
public class MissionRequirementController {

    private final MissionRequirementService missionRequirementService;
    private final MissionRequirementMapper missionRequirementMapper;

    @DeleteMapping("delete/{id}")
    public ResponseEntity<MissionRequirementResponseDto> deleteMissionRequirement(
            @PathVariable Long id
    ) {
        log.info("deleteMissionRequirement");
        missionRequirementService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<MissionRequirementResponseDto>> getAllMissionRequirements(
    ) {
        log.info("getAllMissionRequirements");
        return ResponseEntity.ok(missionRequirementMapper.toResponse(missionRequirementService.findAll()));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<MissionRequirementResponseDto> getMissionRequirementById(
            @PathVariable Long id
    ) {
        log.info("getMissionRequirementById");
        return ResponseEntity.ok(missionRequirementMapper.toResponse(missionRequirementService.findById(id)));
    }

    @PatchMapping("/setCurrentAmount/{id}")
    public ResponseEntity<MissionRequirementResponseDto> setTaskProgress(
            @PathVariable Long id,
            @RequestParam Long currentAmount
    ) {
        log.info("setTaskProgress");
        return ResponseEntity.ok(missionRequirementMapper.toResponse(missionRequirementService.setCurrentAmount(id, currentAmount)));
    }

    @PostMapping("/create")
    public ResponseEntity<MissionRequirementResponseDto> postMissionRequirement(
            @RequestBody MissionRequirementRequestDto missionRequirementRequestDto
    ) {
        log.info("addMissionRequirement");
        MissionRequirement missionRequirementSaved = missionRequirementService.save(missionRequirementMapper.toModel(missionRequirementRequestDto));
        return ResponseEntity.created(null).body(missionRequirementMapper.toResponse(missionRequirementSaved));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<MissionRequirementResponseDto> putMissionRequirement(
            @PathVariable Long id,
            @RequestBody MissionRequirementRequestDto missionRequirementRequestDto
    ) {
        log.info("putMissionRequirement");
        MissionRequirement missionRequirementUpdated = missionRequirementService.update(id, missionRequirementMapper.toModel(missionRequirementRequestDto));
        return ResponseEntity.ok(missionRequirementMapper.toResponse(missionRequirementUpdated));
    }

}