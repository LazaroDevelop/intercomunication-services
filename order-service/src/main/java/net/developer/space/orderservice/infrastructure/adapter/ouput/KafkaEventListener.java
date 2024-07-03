package net.developer.space.orderservice.infrastructure.adapter.ouput;

import net.developer.space.orderservice.infrastructure.annotations.OrderListener;
import net.developer.space.orderservice.ports.output.OrderEventListener;
import net.developer.space.servicecore.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@OrderListener
public class KafkaEventListener implements OrderEventListener {

    @Value("${kafka.topic.name}")
    private String topic;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    KafkaEventListener(KafkaTemplate<String, OrderEvent> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public void send(OrderEvent orderEvent) {
        ListenableFuture<SendResult<String, OrderEvent>> future = kafkaTemplate.send(topic, orderEvent);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error("kafka.send.error: {}", ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, OrderEvent> result) {
                logger.debug("kafka.send.successfully: {}", result);
            }
        });

    }
}
