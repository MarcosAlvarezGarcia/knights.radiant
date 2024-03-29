package marcos.knights.radiant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.dtos.surge.SurgeRequestDto;
import marcos.knights.radiant.dtos.surge.SurgeResponseDto;
import marcos.knights.radiant.mappers.SurgeMapper;
import marcos.knights.radiant.models.Surge;
import marcos.knights.radiant.services.surge.SurgeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/knightsRadiant/surges")
@CrossOrigin (origins = "http://localhost:4200")
@RequiredArgsConstructor
@Slf4j
public class SurgeController {

    private final SurgeService surgeService;
    private final SurgeMapper surgeMapper;

    @DeleteMapping("delete/{id}")
    public ResponseEntity<SurgeResponseDto> deleteSurge(
            @PathVariable Long id
    ) {
        log.info("deleteSurge");
        surgeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<SurgeResponseDto>> getAllSurges(
    ) {
        log.info("getAllSurges");
        return ResponseEntity.ok(surgeMapper.toResponse(surgeService.findAll()));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<SurgeResponseDto> getSurgeById(
            @PathVariable Long id
    ) {
        log.info("getSurgeById");
        return ResponseEntity.ok(surgeMapper.toResponse(surgeService.findById(id)));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<SurgeResponseDto>> getSurgesByTitle(
            @PathVariable String name
    ) {
        log.info("getSurgesByName");
        return ResponseEntity.ok(surgeMapper.toResponse(surgeService.findByName(name))
        );
    }

    @PostMapping("/create")
    public ResponseEntity<SurgeResponseDto> postSurge(
            @RequestBody SurgeRequestDto surgeRequestDto
    ) {
        log.info("addSurge");
        Surge surgeSaved = surgeService.save(surgeMapper.toModel(surgeRequestDto));
        return ResponseEntity.created(null).body(surgeMapper.toResponse(surgeSaved));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<SurgeResponseDto> putSurge(
            @PathVariable Long id,
            @RequestBody SurgeRequestDto surgeRequestDto
    ) {
        log.info("putSurge");
        Surge surgeUpdated = surgeService.update(id, surgeMapper.toModel(surgeRequestDto));
        return ResponseEntity.ok(surgeMapper.toResponse(surgeUpdated));
    }

}