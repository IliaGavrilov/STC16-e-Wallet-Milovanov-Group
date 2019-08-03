package com.service;

import com.entity.Bank;
import com.entity.TypeOfBankBill;

import java.util.List;

public interface GetBankByIdService {
    Bank getBankById(Long id);
    List<TypeOfBankBill> getAllTypesOfBankBill();
}
