package com.trade.customerService.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.trade.customerService.model.Customer;






@Repository
public interface CustDao {
	

	//List<Customer> getCustbyAccount(String tradeAccountNo);
	List<Customer> getCustbyId(String customerId);
}
