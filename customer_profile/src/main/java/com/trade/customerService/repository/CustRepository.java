package com.trade.customerService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trade.customerService.model.Customer;


@Repository
public interface CustRepository extends MongoRepository<Customer, String>{

}
