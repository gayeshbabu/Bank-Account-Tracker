package com.customerAccountTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customerAccountTracker.entity.Account;
import com.customerAccountTracker.entity.Customer;


@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

	
	
	@Query("SELECT a FROM Account a LEFT JOIN FETCH a.customer c ON a.phoneNumber = c.customer.phoneNumber")
	List<Account> getAllAccounts();
	
	
	
	 @Query("SELECT c FROM Customer c  JOIN FETCH c.accounts")
	   List<Customer> getAllCustomersWithAccounts();
	
}
