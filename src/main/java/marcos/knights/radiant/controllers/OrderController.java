package marcos.knights.radiant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcos.knights.radiant.dtos.order.OrderRequestDto;
import marcos.knights.radiant.dtos.order.OrderResponseDto;
import marcos.knights.radiant.mappers.OrderMapper;
import marcos.knights.radiant.models.RadiantOrder;
import marcos.knights.radiant.services.order.RadiantOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knightsRadiant/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final RadiantOrderService radiantOrderService;
    private final OrderMapper orderMapper;

    @DeleteMapping("delete/{id}")
    public ResponseEntity<OrderResponseDto> deleteOrder(
            @PathVariable Long id
    ) {
        log.info("deleteOrder");
        radiantOrderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<OrderResponseDto>> getAllOrders(
    ) {
        log.info("getAllOrders");
        return ResponseEntity.ok(orderMapper.toResponse(radiantOrderService.findAll()));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<OrderResponseDto> getOrderById(
            @PathVariable Long id
    ) {
        log.info("getOrderById");
        return ResponseEntity.ok(orderMapper.toResponse(radiantOrderService.findById(id)));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<OrderResponseDto>> getOrdersByTitle(
            @PathVariable String name
    ) {
        log.info("getOrdersByTitle");
        return ResponseEntity.ok(orderMapper.toResponse(radiantOrderService.findByName(name))
        );
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponseDto> postOrder(
            @RequestBody OrderRequestDto orderRequestDto
    ) {
        log.info("addOrder");
        RadiantOrder radiantOrderSaved = radiantOrderService.save(orderMapper.toModel(orderRequestDto));
        return ResponseEntity.created(null).body(orderMapper.toResponse(radiantOrderSaved));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<OrderResponseDto> putOrder(
            @PathVariable Long id,
            @RequestBody OrderRequestDto orderRequestDto
    ) {
        log.info("putOrder");
        RadiantOrder radiantOrderUpdated = radiantOrderService.update(id, orderMapper.toModel(orderRequestDto));
        return ResponseEntity.ok(orderMapper.toResponse(radiantOrderUpdated));
    }

}