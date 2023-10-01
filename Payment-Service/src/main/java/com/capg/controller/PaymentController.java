package com.capg.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capg.entity.Payment;
import com.capg.service.PaymentService;
import com.capg.vo.ResponseTemplateVO;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	public PaymentService paymentService;
	
	
	@PostMapping("/")
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
		return new ResponseEntity<Payment>(paymentService.createPayment(payment),HttpStatus.CREATED);
	}
	@DeleteMapping("/")
	public ResponseEntity<String> deleteAll(){
		paymentService.deleteAll();
		return ResponseEntity.ok("Deleted all payments...");
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePaymentById(@PathVariable int id){
		paymentService.deletePaymentById(id);
		return ResponseEntity.ok("Id is deleted....");
	}
	@GetMapping("/{id}")
	public ResponseTemplateVO getPaymentByBill(@PathVariable("id") int id) {
		return paymentService.getPaymentByBill(id);
	}
	@GetMapping("/")
	public ResponseEntity<List<Payment>> getallPayments(){
		return new ResponseEntity<List<Payment>>(paymentService.getallPayments(),HttpStatus.OK);
		
	}
}
