package com.trade.customerService.model.response;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortFolio {
	private String tradeAccountNo;
    private Double balance;
    private String linkedBankAccount;
    private Map<String,Integer> portfolio;
}
