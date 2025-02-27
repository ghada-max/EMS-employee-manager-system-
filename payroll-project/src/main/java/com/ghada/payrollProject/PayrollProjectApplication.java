package com.ghada.payrollProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PayrollProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollProjectApplication.class, args);
	}

}
