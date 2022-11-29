package com.trade.customerService.model.response;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Addressdetails {
	private String area;
	private String city;
	private String pincode;
}
