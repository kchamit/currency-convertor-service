package com.curr.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConvertorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConvertorServiceApplication.class, args);
	}
}

