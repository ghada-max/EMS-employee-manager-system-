package com.ghada.bankConsumer.controller;

import com.ghada.bankConsumer.bankService;
import com.ghada.bankConsumer.paymentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class bankController {

    @Autowired
    bankService service;

    @GetMapping("/getEvents")
    public List<paymentEvent> getpaymentEventsList(){
        return service.getAllEvents();
    }
}
