package com.trade.customerService.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.trade.customerService.model.Customer;



@Repository
public class CustDaoRepo implements CustDao {

	@Autowired
	MongoTemplate mongoTemplate;
   
@Override
public List<Customer> getCustbyId(String customerId) {
	Query query = new Query();
	query.addCriteria(Criteria.where("customerId").is(customerId));
	List<Customer> customer1= mongoTemplate.find(query, Customer.class);
	return customer1;
	
}
}









