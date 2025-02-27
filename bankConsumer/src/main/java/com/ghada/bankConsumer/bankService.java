package com.ghada.bankConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

@Slf4j
@Service
public class bankService {
    private final List<paymentEvent> eventsList = new CopyOnWriteArrayList<>(); // Thread-safe

    @Transactional
    @KafkaListener(topics="paymentevent_transaction",groupId="paymentEvent-group")
    public List<paymentEvent> handlePaymentEvents(paymentEvent message){
        paymentEvent event=paymentEvent.builder()
                .name(message.getName())
                .email(message.getEmail())
                .bankAccount(message.getBankAccount())
                .contact(message.getContact())
                .amount(message.getAmount())
                .employeeId(message.getEmployeeId())
                .build();
        eventsList.add(event);
        log.info("Received Message: {}", event);
        return eventsList;

    }
    public List<paymentEvent> getAllEvents() {
        return eventsList;
    }

    public makePayment(){


    }
 //after payment results we send the result to the organizationnto see the result and prosecc notifications
}
