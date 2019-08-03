package com.repository;

import com.entity.BankBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;


@Repository
public interface BankBillRepository extends JpaRepository<BankBill, Long> {

    List<BankBill> bankBills = new ArrayList<>();

}
