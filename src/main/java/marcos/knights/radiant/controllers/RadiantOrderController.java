package marcos.knights.radiant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.dtos.radiantOrder.RadiantOrderRequestDto;
import marcos.knights.radiant.dtos.radiantOrder.RadiantOrderResponseDto;
import marcos.knights.radiant.mappers.RadiantOrderMapper;
import marcos.knights.radiant.models.RadiantOrder;
import marcos.knights.radiant.services.radiantOrder.RadiantOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knightsRadiant/radiantOrders")
@RequiredArgsConstructor
@Slf4j
public class RadiantOrderController {

    private final RadiantOrderService radiantOrderService;
    private final RadiantOrderMapper radiantOrderMapper;

    @DeleteMapping("delete/{id}")
    public ResponseEntity<RadiantOrderResponseDto> deleteRadiantOrder(
            @PathVariable Long id
    ) {
        log.info("deleteRadiantOrder");
        radiantOrderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<RadiantOrderResponseDto>> getAllRadiantOrders(
    ) {
        log.info("getAllRadiantOrders");
        return ResponseEntity.ok(radiantOrderMapper.toResponse(radiantOrderService.findAll()));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<RadiantOrderResponseDto> getRadiantOrderById(
            @PathVariable Long id
    ) {
        log.info("getRadiantOrderById");
        return ResponseEntity.ok(radiantOrderMapper.toResponse(radiantOrderService.findById(id)));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<RadiantOrderResponseDto>> getRadiantOrdersByTitle(
            @PathVariable String name
    ) {
        log.info("getRadiantOrdersByTitle");
        return ResponseEntity.ok(radiantOrderMapper.toResponse(radiantOrderService.findByName(name))
        );
    }

    @PostMapping("/create")
    public ResponseEntity<RadiantOrderResponseDto> postRadiantOrder(
            @RequestBody RadiantOrderRequestDto radiantOrderRequestDto
    ) {
        log.info("addRadiantOrder");
        RadiantOrder radiantOrderSaved = radiantOrderService.save(radiantOrderMapper.toModel(radiantOrderRequestDto));
        return ResponseEntity.created(null).body(radiantOrderMapper.toResponse(radiantOrderSaved));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<RadiantOrderResponseDto> putRadiantOrder(
            @PathVariable Long id,
            @RequestBody RadiantOrderRequestDto radiantOrderRequestDto
    ) {
        log.info("putRadiantOrder");
        RadiantOrder radiantOrderUpdated = radiantOrderService.update(id, radiantOrderMapper.toModel(radiantOrderRequestDto));
        return ResponseEntity.ok(radiantOrderMapper.toResponse(radiantOrderUpdated));
    }

}