package net.developer.space.orderservice.infrastructure.adapter.input;

import net.developer.space.orderservice.domain.OrderModel;
import net.developer.space.orderservice.infrastructure.annotations.InputAdapter;
import net.developer.space.orderservice.ports.input.OrderEventUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@InputAdapter
@RequestMapping("v1/api/orders")
public class OrderController {
    private final OrderEventUseCase useCase;

    @Autowired
    OrderController(OrderEventUseCase useCase){
        this.useCase = useCase;
    }

    @PostMapping("/put-order")
    ResponseEntity<String> produceMessage(@RequestBody OrderModel model){
        useCase.sendMessage(model);
        return ResponseEntity.ok("The order was send...");
    }
}
