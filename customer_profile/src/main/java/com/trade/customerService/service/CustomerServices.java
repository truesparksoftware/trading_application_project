package com.trade.customerService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.customerService.model.Customer;
import com.trade.customerService.repository.CustRepository;



@Service
public class CustomerServices {

	@Autowired
	CustRepository custRepository;

	public Customer postCustomer(Customer customerProfile) {
		Customer customer=custRepository.save(customerProfile);
		return customer;
	}

	public List<Customer> getallcustomer() {
		List<Customer> customer=custRepository.findAll();
		return customer;
	}

	
	public Customer updateCustomer(String id, Customer customerProfile) {
		Optional<Customer> customer=custRepository.findById(id);
		Customer customer1=customer.get();
		customer1.setAddress(customerProfile.getAddress());
		customer1.setCustomerId(customerProfile.getCustomerId());
		customer1.setCustomerName(customerProfile.getCustomerName());
		customer1.setDob(customerProfile.getDob());
		customer1.setEmailID(customerProfile.getEmailID());
		customer1.setPan(customerProfile.getPan());
		customer1.setTradeAccountNo(customerProfile.getTradeAccountNo());
		customer1.setPhoneNumber(customerProfile.getPhoneNumber());
		Customer customer2=custRepository.save(customer1);
		return customer2;
	}

	public String deleteCustomer(String id) {
		custRepository.deleteById(id);
		return "Customer deleted";
	}

	public Customer getCustbyAccount(String tradeAccountNo) {
		Optional<Customer> customer=custRepository.findById(tradeAccountNo);
		Customer Customer1=customer.get();
		return Customer1;
	}
	
	//****************************************************************************
	
	
	
	
}
