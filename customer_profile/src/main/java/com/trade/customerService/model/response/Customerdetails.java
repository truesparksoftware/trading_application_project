package com.trade.customerService.model.response;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customerdetails {
	 private String tradeAccountNo;
	private String customerId;
	   private String customerName;
	    private String dob;
	    private String pan;
	    private String phoneNumber;
	    private String emailID;
	    private Addressdetails addressdetails;
}
