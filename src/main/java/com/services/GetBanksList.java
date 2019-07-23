package com.services;

import com.entity.Bank;
import com.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBanksList {

    private final BankRepository bankRepository;

    /**
     * Конструктор
     * Autowired интерфейс репозитория JPA
     * @param bankRepository
     */
    @Autowired
    public GetBanksList(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    /**
     * getBanks
     * @return Список все банков из БД
     */
    public List<Bank> getBanks() {
        return bankRepository.findAll();
    }

}
