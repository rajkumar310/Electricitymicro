package com.capg.vo;

import com.capg.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
	private Bill bill;
	private Payment payment;
	private Customer customer;

	
	
	

}
