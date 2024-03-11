package marcos.knights.radiant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.dtos.mission.MissionRequestDto;
import marcos.knights.radiant.dtos.mission.MissionResponseDto;
import marcos.knights.radiant.dtos.task.TaskResponseDto;
import marcos.knights.radiant.mappers.MissionMapper;
import marcos.knights.radiant.models.Mission;
import marcos.knights.radiant.models.Task;
import marcos.knights.radiant.services.mission.MissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knightsRadiant/missions")
@RequiredArgsConstructor
@Slf4j
public class MissionController {

    private final MissionService missionService;
    private final MissionMapper missionMapper;

    @DeleteMapping("delete/{id}")
    public ResponseEntity<MissionResponseDto> deleteMission(
            @PathVariable Long id
    ) {
        log.info("deleteMission");
        missionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<MissionResponseDto>> getAllMissions(
    ) {
        log.info("getAllMissions");
        return ResponseEntity.ok(missionMapper.toResponse(missionService.findAll()));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<MissionResponseDto> getMissionById(
            @PathVariable Long id
    ) {
        log.info("getMissionById");
        return ResponseEntity.ok(missionMapper.toResponse(missionService.findById(id)));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<MissionResponseDto>> getMissionsByTitle(
            @PathVariable String title
    ) {
        log.info("getMissionsByTitle");
        return ResponseEntity.ok(missionMapper.toResponse(missionService.findByTitle(title))
        );
    }

    @PatchMapping("/setActive/{id}")
    public ResponseEntity<MissionResponseDto> setMissionActive(
            @PathVariable Long id,
            @RequestParam boolean active
    ) {
        log.info("setMissionActive");
        return ResponseEntity.ok(missionMapper.toResponse(missionService.setActive(id, active)));
    }

    @PatchMapping("/addMessageToMission/{id}")
    public ResponseEntity<MissionResponseDto> addMessageToMission(
            @PathVariable Long id,
            @RequestParam Long messageId
    ) {
        log.info("addMessageToMission");
        return ResponseEntity.ok(missionMapper.toResponse(missionService.addMessageToMission(id, messageId)));
    }

    @PatchMapping("/addTaskToMission/{id}")
    public ResponseEntity<MissionResponseDto> addTaskToMission(
            @PathVariable Long id,
            @RequestParam Long taskId
    ) {
        log.info("addTaskToMission");
        return ResponseEntity.ok(missionMapper.toResponse(missionService.addTaskToMission(id, taskId)));
    }

    @PatchMapping("/setDone/{id}")
    public ResponseEntity<MissionResponseDto> setMissionDone(
            @PathVariable Long id,
            @RequestParam boolean done
    ) {
        log.info("setMissionDone");
        return ResponseEntity.ok(missionMapper.toResponse(missionService.setDone(id, done)));
    }

    @PostMapping("/create")
    public ResponseEntity<MissionResponseDto> postMission(
            @RequestBody MissionRequestDto missionRequestDto
    ) {
        log.info("addMission");
        Mission missionSaved = missionService.save(missionMapper.toModel(missionRequestDto));
        return ResponseEntity.created(null).body(missionMapper.toResponse(missionSaved));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<MissionResponseDto> putMission(
            @PathVariable Long id,
            @RequestBody MissionRequestDto missionRequestDto
    ) {
        log.info("putMission");
        Mission missionUpdated = missionService.update(id, missionMapper.toModel(missionRequestDto));
        return ResponseEntity.ok(missionMapper.toResponse(missionUpdated));
    }

}