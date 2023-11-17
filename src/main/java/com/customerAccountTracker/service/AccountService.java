package com.customerAccountTracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerAccountTracker.entity.Account;
import com.customerAccountTracker.entity.Customer;
import com.customerAccountTracker.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepo;

	public void addAccount(Account account) {
		accountRepo.save(account);

	}

	public List<Customer> getAllAccounts() {

		return new ArrayList<>(accountRepo.getAllCustomersWithAccounts());
	}

	public List<Account> findAccounts() {
		return new ArrayList<>(accountRepo.findAll());

	}

	public Optional<Account> fetchBalance(String accountNumber) {

		return accountRepo.findById(accountNumber);

	}

	public String transaferFunds(String from, String to, double amount) {

		// List<Account> accounts = findAccounts();

		// if (account.getAccountNumber().contains(from) &&
		// account.getAccountNumber().contains(to)) {

		Optional<Account> payerAccount = fetchBalance(from);
		Optional<Account> beneficiaryAccount = fetchBalance(to);
		double payerAmount = payerAccount.get().getAccountBalance();
		double beneficaryAmount = beneficiaryAccount.get().getAccountBalance();
		if (payerAmount >= amount) {
			beneficiaryAccount.get().setAccountBalance(amount + beneficaryAmount);
			accountRepo.save(beneficiaryAccount.get());
			payerAccount.get().setAccountBalance(payerAmount - amount);
			accountRepo.save(payerAccount.get());

			return "Success";
		} else {
			return "insufficent Amount";

		}

	}

}
