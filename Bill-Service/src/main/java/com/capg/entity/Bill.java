package com.capg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Bill_details")
public class Bill {
	@Id
	@GeneratedValue
	private int billId;
	private int customerId;

	
	private String meternumber;
	private int units;
	private Long cost;

}
