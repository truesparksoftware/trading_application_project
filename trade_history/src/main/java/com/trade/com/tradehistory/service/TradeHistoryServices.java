package com.trade.com.tradehistory.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.com.tradehistory.model.TradeHistory;
import com.trade.com.tradehistory.repository.TradetRepository;


@Service
public class TradeHistoryServices {

	@Autowired
	TradetRepository tradetRepository;

	public TradeHistory postTradeHistory(TradeHistory tradeHistory) {
		TradeHistory tradeHistory1=tradetRepository.save(tradeHistory);
		return tradeHistory1;
	}

	public List<TradeHistory> getallTradeHistory() {
		List<TradeHistory> tradeHistory=tradetRepository.findAll();
		return tradeHistory;
	}

	public TradeHistory getTradeHistoryById(String id) {
		Optional<TradeHistory> tradeHistory=tradetRepository.findById(id);
		return tradeHistory.get();
	}

	public TradeHistory updateTradeHistory(String id, TradeHistory tradeHistory) {
		Optional<TradeHistory> tradeHistory1=tradetRepository.findById(id);
		TradeHistory tradeHistory2=tradeHistory1.get();
		tradeHistory2.setTradeAccountNo(tradeHistory.getTradeAccountNo());
		tradeHistory2.setDate(tradeHistory.getDate());
		tradeHistory2.setTradeId(tradeHistory.getTradeId());
		tradeHistory2.setTradeName(tradeHistory.getTradeName());
		TradeHistory tradeHistory3=tradetRepository.save(tradeHistory2);
		return tradeHistory3;
	}

	public String deleteTradeHistory(String id) {
		tradetRepository.deleteById(id);
		return "TradeHistory deleted";
	}
	
	//****************************************************************************
	
	
	
	
}
