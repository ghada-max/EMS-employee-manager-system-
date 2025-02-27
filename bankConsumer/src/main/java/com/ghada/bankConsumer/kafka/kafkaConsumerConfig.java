package com.ghada.bankConsumer.kafka;

import com.ghada.bankConsumer.paymentEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@EnableKafka
@Configuration
public class kafkaConsumerConfig {
    @Bean
    public ConsumerFactory<String, paymentEvent> consumerFactory(){
        JsonDeserializer<paymentEvent> jsonDeserializer = new JsonDeserializer<>(paymentEvent.class);
        jsonDeserializer.setRemoveTypeHeaders(true);

        return new DefaultKafkaConsumerFactory<>(Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ConsumerConfig.GROUP_ID_CONFIG, "paymentEvent-group",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, paymentEventDeserializer.class        ));

    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,paymentEvent> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,paymentEvent> factory=new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
