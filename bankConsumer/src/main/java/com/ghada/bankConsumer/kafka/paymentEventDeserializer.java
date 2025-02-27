package com.ghada.bankConsumer.kafka;
import com.ghada.bankConsumer.paymentEvent;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class paymentEventDeserializer implements Deserializer<paymentEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public paymentEvent deserialize(String topic, byte[] data) {
        try {
            if (data == null) {
                return null;
            }
            return objectMapper.readValue(data, paymentEvent.class);
        } catch (Exception e) {
            throw new SerializationException("Error deserializing paymentEvent", e);
        }
    }

    @Override
    public void close() {
        // No-op
    }
}


