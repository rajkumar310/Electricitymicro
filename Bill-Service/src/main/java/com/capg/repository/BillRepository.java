package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

	Bill findByBillId(int billId);

}
