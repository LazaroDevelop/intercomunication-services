package net.developer.space.orderservice.application.service;

import net.developer.space.orderservice.domain.OrderModel;
import net.developer.space.orderservice.infrastructure.annotations.InputPort;
import net.developer.space.orderservice.ports.input.OrderEventUseCase;
import net.developer.space.orderservice.ports.output.OrderEventListener;
import net.developer.space.servicecore.dto.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;


@InputPort
public class OrderService implements OrderEventUseCase {

    private final OrderEventListener eventListener;

    @Autowired
    OrderService(OrderEventListener eventListener){
        this.eventListener = eventListener;
    }

    @Override
    public void sendMessage(OrderModel model) {
        this.eventListener.send(new OrderEvent(model.getMessage(), model.getStatus(), model.getOrder()));
    }
}
