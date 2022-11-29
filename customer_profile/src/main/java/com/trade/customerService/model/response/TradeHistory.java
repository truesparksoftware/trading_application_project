package com.trade.customerService.model.response;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeHistory {
	private String tradeId;
	private String tradeName;
	private String tradeAccountNo;
	private String tradeDate;
}
