package com.repository;

import com.entity.TypeOfBankBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankBillTypeRepository extends JpaRepository<TypeOfBankBill, Long> {
}
