package net.developer.space.orderservice.ports.output;

import net.developer.space.servicecore.dto.OrderEvent;

public interface OrderEventListener {
    public void send(OrderEvent orderEvent);
}
