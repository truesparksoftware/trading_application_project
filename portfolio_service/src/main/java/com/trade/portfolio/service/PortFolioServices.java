package com.trade.portfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.portfolio.model.PortFolio;
import com.trade.portfolio.repository.PortFolioRepository;

@Service
public class PortFolioServices {

	@Autowired
	PortFolioRepository portFolioRepository;

	public PortFolio postPortFolio(PortFolio portFolio) {
		PortFolio tradeHistory1=portFolioRepository.save(portFolio);
		return tradeHistory1;
	}

	public List<PortFolio> getallportFolio() {
		List<PortFolio> portFolio=portFolioRepository.findAll();
		return portFolio;
	}

	public PortFolio getPortFolioById(String tradeAccountNo) {
		Optional<PortFolio> portFolio=portFolioRepository.findById(tradeAccountNo);
		return portFolio.get();
	}

	public PortFolio updatePortFolio(String id, PortFolio portFolio) {
		Optional<PortFolio> PortFolio2=portFolioRepository.findById(id);
		PortFolio PortFolio3=PortFolio2.get();
		PortFolio3.setBalance(portFolio.getBalance());
		PortFolio3.setLinkedBankAccount(portFolio.getLinkedBankAccount());
		PortFolio3.setPortfolio(portFolio.getPortfolio());
		PortFolio3.setTradeAccountNo(portFolio.getTradeAccountNo());
		PortFolio portFolio4=portFolioRepository.save(PortFolio3);
		return portFolio4;
	}

	public String deleteportFolio(String id) {
		portFolioRepository.deleteById(id);
		return "TradeHistory deleted";
	}
	
	//****************************************************************************
	
	
	
	
}
