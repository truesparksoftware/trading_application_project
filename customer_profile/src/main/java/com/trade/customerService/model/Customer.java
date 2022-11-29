package com.trade.customerService.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Customer {
	@MongoId
	private String tradeAccountNo;
	private String customerId;
	private String customerName;
	private String dob;
	private String pan;
	private String phoneNumber;
	private String emailID;
	private Address address;
}
