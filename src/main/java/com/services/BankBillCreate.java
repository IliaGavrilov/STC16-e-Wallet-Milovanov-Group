package com.services;

import com.entity.BankBill;
import com.repository.BankBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service(value = "bankBillCreate")
public class BankBillCreate {

    @Autowired
    @Qualifier("bankBillRepository")
    private BankBillRepository bankBillRepository;


    public BankBill save(BankBill bankBill) {
        bankBill = bankBillRepository.saveAndFlush( bankBill );
        return bankBill;
    }
}
