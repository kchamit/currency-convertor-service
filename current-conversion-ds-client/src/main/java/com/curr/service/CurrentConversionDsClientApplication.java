package com.curr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrentConversionDsClientApplication implements CommandLineRunner {

	@Autowired
	private ConversionFactorDataServiceClient conversionFactorDataServiceClient;
	
	public static void main(String[] args) {
		SpringApplication.run(CurrentConversionDsClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application started....");
		ConversionFactor conversionFactor = conversionFactorDataServiceClient.getConversionFactor(args[1]);
		System.out.println(conversionFactor.getFactor());
	}

}
