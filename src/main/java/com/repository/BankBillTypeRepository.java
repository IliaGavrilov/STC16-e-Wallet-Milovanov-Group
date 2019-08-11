package com.repository;

import com.entity.TypeOfBankBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankBillTypeRepository extends JpaRepository<TypeOfBankBill, Long> {

    //@Query("SELECT title FROM typeofbankbill")
    List<TypeOfBankBill> findAll();

    long count();
}
