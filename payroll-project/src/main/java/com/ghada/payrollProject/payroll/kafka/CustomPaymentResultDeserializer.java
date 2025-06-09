package com.ghada.payrollProject.payroll.kafka;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghada.payrollProject.payroll.dto.paymentResult;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class CustomPaymentResultDeserializer implements Deserializer<paymentResult> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public paymentResult deserialize(String topic, byte[] data) {
        try {
            if (data == null) {
                return null;
            }
            return objectMapper.readValue(data, paymentResult.class);
        } catch (Exception e) {
            throw new SerializationException("Error deserializing paymentResult", e);
        }
    }

    @Override
    public void close() {
        // No-op
    }
}


