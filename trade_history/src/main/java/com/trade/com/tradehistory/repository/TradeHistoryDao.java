package com.trade.com.tradehistory.repository;





import java.util.List;

import org.springframework.stereotype.Repository;

import com.trade.com.tradehistory.model.TradeHistory;



@Repository
public interface TradeHistoryDao {
	

	List<TradeHistory> getTradeHisbyAccount(String tradeAccountNo);

}
