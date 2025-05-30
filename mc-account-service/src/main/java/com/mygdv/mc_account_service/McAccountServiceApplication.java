package com.mygdv.mc_account_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class McAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(McAccountServiceApplication.class, args);
	}

}
