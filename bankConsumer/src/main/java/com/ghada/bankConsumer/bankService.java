package com.ghada.bankConsumer;
import com.ghada.bankConsumer.enums.BankPaymentResult;
import com.ghada.bankConsumer.objects.paymentEvent;
import com.ghada.bankConsumer.objects.paymentResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class bankService {
    private final List<paymentEvent> eventsList = new CopyOnWriteArrayList<>(); // Thread-safe
    @Autowired
    private KafkaTemplate<String,paymentResult> kafkaTemplate;
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

    public List<paymentResult> makePayment(){
        List<paymentResult> paymentResults=new ArrayList<>();
        List<paymentEvent> events=this.getAllEvents();
        events.stream().forEach(event->{
            BankPaymentResult status = BankPaymentResult.values()[ThreadLocalRandom.current().nextInt(BankPaymentResult.values().length)];

            paymentResult result= paymentResult.builder().
            id(event.getEmployeeId())
                    .ammount(event.getAmount())
                    .BankPaymentResult(status)
            .build();
            paymentResults.add(result);

            //create kafka Result producer
            String topic="paymentResult";
            kafkaTemplate.send(topic,result);
        });
        return paymentResults;


    }
 //after payment results we send the result to the organizationnto see the result and prosecc notifications
}
