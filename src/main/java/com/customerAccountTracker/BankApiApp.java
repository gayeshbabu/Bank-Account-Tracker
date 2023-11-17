package com.customerAccountTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.customerAccountTracker.service.AccountService;

@SpringBootApplication
public class BankApiApp {

	public static void main(String[] args) {
		
		SpringApplication.run(BankApiApp.class, args);
	
         
	}
}
