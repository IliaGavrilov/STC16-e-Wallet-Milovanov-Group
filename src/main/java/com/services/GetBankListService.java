package com.services;

import com.entity.Bank;
import com.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBankListService {

    private final BankRepository bankRepository;

    @Autowired
    public GetBankListService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> getBank() {
        return bankRepository.findAll();
    }

}
