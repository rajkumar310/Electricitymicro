package com.capg.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bill {
	
	private int billId;
//	private int customerId;
	
	private String meternumber;
	private int units;
	private Long cost;

}
