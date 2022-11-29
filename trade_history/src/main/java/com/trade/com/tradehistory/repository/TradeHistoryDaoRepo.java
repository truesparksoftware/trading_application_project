package com.trade.com.tradehistory.repository;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.trade.com.tradehistory.model.TradeHistory;


@Repository
public class TradeHistoryDaoRepo implements TradeHistoryDao {

	@Autowired
	MongoTemplate mongoTemplate;
   @Override
	public List<TradeHistory> getTradeHisbyAccount(String tradeAccountNo) {
		Query query = new Query();
		query.addCriteria(Criteria.where("tradeAccountNo").is(tradeAccountNo));
		List<TradeHistory> tradeHistory=mongoTemplate.find(query, TradeHistory.class);
		return tradeHistory;
	}
}









