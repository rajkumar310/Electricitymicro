package com.capg.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;


import com.capg.entity.Payment;
import com.capg.repository.PaymentRepository;
import com.capg.vo.Bill;
import com.capg.vo.Customer;
import com.capg.vo.ResponseTemplateVO;

@Service
public class PaymentService {
	@Autowired
	public PaymentRepository paymentRepository;
	
	@Autowired
	public RestTemplate restTemplate;

	public Payment createPayment(Payment payment) {
		
		return paymentRepository.save(payment);
	}

	public void deleteAll() {
		paymentRepository.deleteAll();
		
	}

	public void deletePaymentById(int id) {
		// TODO Auto-generated method stub
		paymentRepository.deleteById(id);
		
	}



	public ResponseTemplateVO getPaymentByBill(int paymentId) {
	    ResponseTemplateVO vo = new ResponseTemplateVO();
	    Payment payment = paymentRepository.findByPaymentId(paymentId);
	    if(payment == null) {
	        throw new RuntimeException("Payment not found for id: " + paymentId);
	    }

	    Customer customer = restTemplate.getForObject("http://CUSTOMER-SERVICE/customer/" + payment.getCustomerId(), Customer.class);
	    
	    Bill bill = restTemplate.getForObject("http://BILL-SERVICE/bill/" + payment.getBillId(), Bill.class);
	    if(bill == null) {
	        throw new RuntimeException("Bill not found for id: " + payment.getBillId());
	    }
	    vo.setCustomer(customer);
	    vo.setBill(bill);
	    vo.setPayment(payment);
	   
	    
	    return vo;
	}


	public List<Payment> getallPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}



	}
		

	


