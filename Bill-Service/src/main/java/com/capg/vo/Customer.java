package com.capg.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
	
	private int customerId;
	private String name;
	private Long number;
	private String address;
	private String email;

}
