package com.trade.customerService.model.response;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
public List<TradeHistory> tradeHistory;
public PortFolio portFolio;
public Customerdetails customerdetails;
}
