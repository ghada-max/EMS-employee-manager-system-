package com.ghada.payrollProject.payroll.kafka;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghada.payrollProject.payroll.employeeDto.employee;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class CustomEmployeeDeserializer implements Deserializer<employee> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public employee deserialize(String topic, byte[] data) {
        try {
            if (data == null) {
                return null;
            }
            return objectMapper.readValue(data, employee.class);
        } catch (Exception e) {
            throw new SerializationException("Error deserializing employee", e);
        }
    }

    @Override
    public void close() {
        // No-op
    }
}


