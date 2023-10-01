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
@Table(name="Payment_details")
public class Payment {
	@Id
	@GeneratedValue
	private int paymentId;
	private int billId;
	private int customerId;
	private String gstNo;
	private String status;

}
