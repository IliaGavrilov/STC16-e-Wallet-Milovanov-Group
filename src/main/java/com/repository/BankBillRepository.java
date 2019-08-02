package com.repository;

import com.entity.BankBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankBillRepository extends JpaRepository<BankBill, Long> {
}
