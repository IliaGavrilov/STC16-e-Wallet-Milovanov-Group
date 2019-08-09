package com.serviceImpl;

import com.entity.BankBill;
import com.entity.User;
import com.repository.BankBillRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "bankBillCreate")
public class BankBillCreateImpl implements com.service.BankBillCreate {

    @Autowired
    private BankBillRepository bankBillRepository;
    private UserRepository userRepository;


    public BankBill save(BankBill bankBill) {
        bankBill = bankBillRepository.saveAndFlush( bankBill );
        return bankBill;
    }

    public User findUserByName(Object name) {
        return userRepository.findUserByName( name.toString() );
    }
}
