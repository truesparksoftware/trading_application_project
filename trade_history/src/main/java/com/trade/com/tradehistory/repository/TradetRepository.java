package com.trade.com.tradehistory.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trade.com.tradehistory.model.TradeHistory;

@Repository
public interface TradetRepository extends MongoRepository<TradeHistory, String>{

}
