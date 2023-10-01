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

import com.capg.entity.Bill;
import com.capg.service.BillService;
import com.capg.vo.ResponseTemplateVO;


@RestController
@RequestMapping("/bill")
public class BillController {
	@Autowired
	private BillService billService;
	
	@PostMapping("/")
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill){
		return new ResponseEntity<Bill>(billService.addBill(bill),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletebillById(@PathVariable int id){
		billService.deletebillById(id);
		return ResponseEntity.ok("Bill is been Deleted");
	}
	@DeleteMapping("/")
	public ResponseEntity<String> deleteAll(){
		billService.deleteAll();
		return ResponseEntity.ok("Deleted All Bills");
	}
	@GetMapping("/bill/{id}")
	public ResponseTemplateVO getBillByCustomer(@PathVariable("id") int billId) {
		return billService.getBillByCustomer(billId);
	}
	@GetMapping("/{id}")
	public Bill getBillById(@PathVariable("id") int id) {
	    return billService.findBillById(id);
	}

	@GetMapping("/")
	public ResponseEntity<List<Bill>> getAllBills(){
		return new ResponseEntity<List<Bill>>(billService.getAllBills(),HttpStatus.OK);
	}
	

}
