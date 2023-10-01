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
@Table(name="Customer_details")
public class Customer {
	@Id
	@GeneratedValue
	private int customerId;
	private String name;
	private Long number;
	private String address;
	private String email;

}
