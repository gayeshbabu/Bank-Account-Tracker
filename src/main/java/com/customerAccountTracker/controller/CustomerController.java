package com.customerAccountTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerAccountTracker.entity.Account;
import com.customerAccountTracker.entity.Customer;
import com.customerAccountTracker.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/addCustomer")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);

	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	
	@GetMapping("/customersWithAccounts")
	public List<Customer> getAllCustomersWithAccounts(){
		return customerService.getAllCustomersWithAccounts();
	}

}
