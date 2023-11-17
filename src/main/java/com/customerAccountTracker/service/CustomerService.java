package com.customerAccountTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerAccountTracker.entity.Account;
import com.customerAccountTracker.entity.Customer;
import com.customerAccountTracker.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	public Customer addCustomer(Customer customer) {

		return customerRepo.save(customer);

	}

	public List<Customer> getAllCustomers() {

		List<Customer> customers = new ArrayList<>();
		customerRepo.findAll().forEach(customers::add);
		return customers;

	}

	public List<Customer> getAllCustomersWithAccounts() {

		return customerRepo.getAllCustomersWithAccounts();
	}

}
