package net.developer.space.orderservice.infrastructure.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Value("${kafka.topic.name}")
    private String topicName;

    public String getTopicName(){
        return this.topicName;
    }

    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(getTopicName())
                .partitions(3)
                .build();
    }
}
