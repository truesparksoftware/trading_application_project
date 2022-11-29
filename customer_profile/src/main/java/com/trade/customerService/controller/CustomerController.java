package com.trade.customerService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.trade.customerService.model.Customer;
import com.trade.customerService.model.response.Addressdetails;
import com.trade.customerService.model.response.CustomerResponse;
import com.trade.customerService.model.response.Customerdetails;
import com.trade.customerService.model.response.PortFolio;
import com.trade.customerService.model.response.TradeHistory;
import com.trade.customerService.repository.CustDaoRepo;
import com.trade.customerService.service.CustomerServices;


@RestController
@RequestMapping("/cust")
public class CustomerController {
	
	@Autowired
	CustomerServices customerServices;
	@Autowired
	CustDaoRepo custDaoRepo;
	@Value("${portfolioByAcc}")
	private String portfolioByAcc;
	
	@Value("${tradeHisByAcc}")
	private String tradeHisByAcc;
	
	@Autowired
	RestTemplate restTemplate;
	
	//****************************************************************************************
	@PostMapping("/postcustomer")
	private ResponseEntity<Customer> postpaytmCustomer(@RequestBody Customer customerProfile){
		Customer customerProfile1=customerServices.postCustomer(customerProfile);
		return new ResponseEntity<Customer>(customerProfile1, HttpStatus.OK);
	}
	
	
	@GetMapping("/getallcustomer")
	private ResponseEntity<List<Customer>> getallcustomer(){
		List<Customer> customerProfile=customerServices.getallcustomer();
		return new ResponseEntity<List<Customer>>(customerProfile, HttpStatus.OK);
	}
	//
	@GetMapping("/getcustomerid/{id}")
	private ResponseEntity<List<Customer>> getcustomerById(@PathVariable String customerId){
		List<Customer> customerProfile=custDaoRepo.getCustbyId(customerId);
		return new ResponseEntity<List<Customer>>(customerProfile, HttpStatus.OK);
	}
	
	@PutMapping("/put/{id}")
	private ResponseEntity<Customer> updatePaytmCustomer(@PathVariable String id,@RequestBody Customer customerProfile){
		Customer customerProfile1=	customerServices.updateCustomer(id,customerProfile);
	return new ResponseEntity<Customer>(customerProfile1, HttpStatus.OK);
	
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> deletePaytmCustomer(@PathVariable String id){
		String message=	customerServices.deleteCustomer(id);
	return new ResponseEntity<String>(message, HttpStatus.OK);
	
	}

	@GetMapping("/gettradeAccountNo/{tradeAccountNo}")
	private ResponseEntity<CustomerResponse> getcustomerBytradeAccountNo(@PathVariable String tradeAccountNo){
		Customer customerProfile=customerServices.getCustbyAccount(tradeAccountNo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<PortFolio> entity = new HttpEntity<PortFolio>(header);
		Map<String, String> vars = new HashMap<>();
		vars.put("tradeAccountNo", tradeAccountNo);
		ResponseEntity<PortFolio> PortFolio11=restTemplate.exchange(portfolioByAcc, HttpMethod.GET, entity, PortFolio.class, vars);
		PortFolio portFolio=PortFolio11.getBody();
		
		
		  HttpEntity<List<TradeHistory>> entity1 = new HttpEntity<List<TradeHistory>>(header);
		  Map<String, String> vars1 = new HashMap<>(); 
		  vars1.put("tradeAccountNo", tradeAccountNo);
		  ResponseEntity<List<TradeHistory>> tradehis=restTemplate.exchange(tradeHisByAcc,HttpMethod.GET, entity1, new ParameterizedTypeReference<List<TradeHistory>>() {}, vars1); // 
		  
		  
		  List<TradeHistory> tradeHistory1=tradehis.getBody();
		 		
		CustomerResponse customerResponse=new CustomerResponse();
		Customerdetails customerdetails=new Customerdetails();
		TradeHistory tradeHistory2=new TradeHistory();
		Addressdetails addressdetails=new Addressdetails();
		addressdetails.setArea(customerProfile.getAddress().getArea());
		addressdetails.setCity(customerProfile.getAddress().getCity());
		addressdetails.setPincode(customerProfile.getAddress().getPincode());
		
		customerdetails.setCustomerId(customerProfile.getCustomerId());
		customerdetails.setCustomerName(customerProfile.getCustomerName());
		customerdetails.setDob(customerProfile.getDob());
		customerdetails.setEmailID(customerProfile.getEmailID());
		customerdetails.setPan(customerProfile.getPan());
		customerdetails.setPhoneNumber(customerProfile.getPhoneNumber());
		customerdetails.setTradeAccountNo(customerProfile.getTradeAccountNo());
		customerdetails.setAddressdetails(addressdetails);
		
		customerResponse.setCustomerdetails(customerdetails);
		customerResponse.setPortFolio(portFolio);
		

		return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.OK);
	}
}


