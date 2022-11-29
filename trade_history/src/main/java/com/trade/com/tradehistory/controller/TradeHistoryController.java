package com.trade.com.tradehistory.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trade.com.tradehistory.model.TradeHistory;
import com.trade.com.tradehistory.repository.TradeHistoryDaoRepo;
import com.trade.com.tradehistory.service.TradeHistoryServices;


@RestController
@RequestMapping("/trade")
public class TradeHistoryController {
	
	@Autowired
	TradeHistoryServices tradeHistoryServices;
	@Autowired
	TradeHistoryDaoRepo tradeHistoryDaoRepo;
	
	//****************************************************************************************
	@PostMapping("/posttrade")
	private ResponseEntity<TradeHistory> postTradeHistory(@RequestBody TradeHistory tradeHistory){
		TradeHistory tradeHistory1=tradeHistoryServices.postTradeHistory(tradeHistory);
		return new ResponseEntity<TradeHistory>(tradeHistory1, HttpStatus.OK);
	}
	
	
	@GetMapping("/getalltrades")
	private ResponseEntity<List<TradeHistory>> getallTradeHistory(){
		List<TradeHistory> tradeHistory1=tradeHistoryServices.getallTradeHistory();
		return new ResponseEntity<List<TradeHistory>>(tradeHistory1, HttpStatus.OK);
	}
	
	@GetMapping("/gettradeid/{id}")
	private ResponseEntity<TradeHistory>getTradeHistoryById(@PathVariable String id){
		TradeHistory tradeHistory1=tradeHistoryServices.getTradeHistoryById(id);
		return new ResponseEntity<TradeHistory>(tradeHistory1, HttpStatus.OK);
	}
	
	@PutMapping("/put/{id}")
	private ResponseEntity<TradeHistory> updateTradeHistory(@PathVariable String id,@RequestBody TradeHistory tradeHistory1){
		TradeHistory tradeHistory2=	tradeHistoryServices.updateTradeHistory(id,tradeHistory1);
	return new ResponseEntity<TradeHistory>(tradeHistory2, HttpStatus.OK);
	
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> deleteTradeHistory(@PathVariable String id){
		String message=	tradeHistoryServices.deleteTradeHistory(id);
	return new ResponseEntity<String>(message, HttpStatus.OK);
	
	}

	//************get by trade account**************
	
	@GetMapping("/ByTraidAcc/{tradeAccountNo}")
	private ResponseEntity<List<TradeHistory>>getTradeHistoryByTradeAcc(@PathVariable String tradeAccountNo){
		List<TradeHistory> tradeHistory1=tradeHistoryDaoRepo.getTradeHisbyAccount(tradeAccountNo);
		return new ResponseEntity<List<TradeHistory>>(tradeHistory1, HttpStatus.OK);
	}
}
