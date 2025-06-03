package com.mygdv.mc_credit_disbursement_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class McCreditDisbursementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(McCreditDisbursementServiceApplication.class, args);
	}

}
