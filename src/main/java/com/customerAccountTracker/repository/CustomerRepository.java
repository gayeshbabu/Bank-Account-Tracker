package com.customerAccountTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customerAccountTracker.entity.Account;
import com.customerAccountTracker.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	
	/*
	 * @Query("SELECT a FROM Account a RIGHT JOIN FETCH a.customer") List<Account>
	 * getAllCustomersWithAccounts();
	 */
	
	
	 @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.accounts")
	    List<Customer> getAllCustomersWithAccounts();
}

