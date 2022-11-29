package com.trade.portfolio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trade.portfolio.model.PortFolio;

@Repository
public interface PortFolioRepository extends MongoRepository<PortFolio, String>{

}
