package com.customerAccountTracker.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerAccountTracker.entity.Account;
import com.customerAccountTracker.entity.Customer;
import com.customerAccountTracker.service.AccountService;
import com.customerAccountTracker.service.CustomerService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@Autowired
	CustomerService customerService;

	@PostMapping("/addAccount")
	public void addAccount(@RequestBody Account account) {

		Customer savedCustomer = customerService.addCustomer(account.getCustomer());
		account.setCustomer(savedCustomer);

		accountService.addAccount(account);
	}

	/*
	 * @GetMapping("/getAllAccounts") public List<Account> getAllAccounts() { return
	 * accountService.getAllAccounts(); }
	 */

	@GetMapping("/accountsWithCustomers")
	public List<Customer> getAllCustomersWithAccounts() {
		return customerService.getAllCustomersWithAccounts();
	}

	@GetMapping("/getBalance/{accountNumber}")
	public Optional<Account> getBalance(@PathVariable String accountNumber) {
		return accountService.fetchBalance(accountNumber);
	}
    
	@PutMapping("/transferFunds/{from}/{to}/{amount}")
	public String transferFunds(@PathVariable String from, @PathVariable String to, @PathVariable double amount) {
		return accountService.transaferFunds(from, to, amount);
	}

	@GetMapping("/accounts")
	public List<Account> findAllAccounts() {
		return accountService.findAccounts();
	}

}
