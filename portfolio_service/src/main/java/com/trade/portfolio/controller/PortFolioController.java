package com.trade.portfolio.controller;



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

import com.trade.portfolio.model.PortFolio;
import com.trade.portfolio.service.PortFolioServices;




@RestController
@RequestMapping("/portfolio")
public class PortFolioController {
	
	@Autowired
	PortFolioServices portFolioServices;
	
	//****************************************************************************************
	@PostMapping("/createfolio")
	private ResponseEntity<PortFolio> postPortFolio(@RequestBody PortFolio portFolio){
		PortFolio PortFolio2=portFolioServices.postPortFolio(portFolio);
		return new ResponseEntity<PortFolio>(PortFolio2, HttpStatus.OK);
	}
	
	
	@GetMapping("/getallportfolio")
	private ResponseEntity<List<PortFolio>> getallportFolio(){
		List<PortFolio> getallportFolio1=portFolioServices.getallportFolio();
		return new ResponseEntity<List<PortFolio>>(getallportFolio1, HttpStatus.OK);
	}
	
	@GetMapping("/getportfolio/{tradeAccountNo}")
	private ResponseEntity<PortFolio>getPortFolioById(@PathVariable String tradeAccountNo){
		PortFolio PortFolio2=portFolioServices.getPortFolioById(tradeAccountNo);
		return new ResponseEntity<PortFolio>(PortFolio2, HttpStatus.OK);
	}
	
	@PutMapping("/put/{id}")
	private ResponseEntity<PortFolio> updatePortFolio(@PathVariable String id,@RequestBody PortFolio PortFolio){
		PortFolio PortFolio2=	portFolioServices.updatePortFolio(id,PortFolio);
	return new ResponseEntity<PortFolio>(PortFolio2, HttpStatus.OK);
	
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> deleteportFolio(@PathVariable String id){
		String message=	portFolioServices.deleteportFolio(id);
	return new ResponseEntity<String>(message, HttpStatus.OK);
	
	}

}
