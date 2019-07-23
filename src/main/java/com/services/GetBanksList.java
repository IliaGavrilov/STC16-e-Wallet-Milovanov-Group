package com.services;

import com.entity.Bank;
import com.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Рефакторинг названия класса и методов
 */
@Service
public class GetBanksList {

    private final BankRepository bankRepository;

    @Autowired
    public GetBanksList(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> getBanks() {
        return bankRepository.findAll();
    }

}
