package net.developer.space.orderservice.ports.input;

import net.developer.space.orderservice.domain.OrderModel;

public interface OrderEventUseCase {

    void sendMessage(OrderModel model);
}
