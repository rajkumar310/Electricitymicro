package com.capg.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.entity.Bill;
import com.capg.repository.BillRepository;
import com.capg.vo.Customer;
import com.capg.vo.ResponseTemplateVO;


@Service
public class BillService {
	
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private RestTemplate restTemplate;
	

	public Bill addBill(Bill bill) {
		
		return billRepository.save(bill);
	}

	public void deletebillById(int id) {
		
		 billRepository.deleteById(id);
		
	}

	public void deleteAll() {
		
		billRepository.deleteAll();
		
	}

	public ResponseTemplateVO getBillByCustomer(int billId) {
		ResponseTemplateVO vo=new ResponseTemplateVO();
		Bill bill=billRepository.findByBillId(billId);
		if (bill == null) {
	        throw new RuntimeException("Bill not found for id: " + billId);
	    }
		
		Customer customer=restTemplate.getForObject("http://CUSTOMER-SERVICE/customer/"+bill.getCustomerId(),Customer.class);
		vo.setBill(bill);
		vo.setCustomer(customer);
		return vo;
	}

	public List<Bill> getAllBills() {
		// TODO Auto-generated method stub
		return billRepository.findAll();
	}

	public Bill findBillById(int id) {
		// TODO Auto-generated method stub
		return billRepository.findById(id).get();
	}

}
