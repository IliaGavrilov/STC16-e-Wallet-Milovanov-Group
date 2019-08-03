package com.serviceImpl;

import com.entity.Bank;
import com.repository.BankRepository;
import com.service.GetBanksListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBanksListServiceImpl implements GetBanksListService {
    /**
     * spring jpa репозиторий
     */
    private final BankRepository bankRepository;

    /**
     * Конструктор
     * Autowired интерфейс репозитория JPA
     * @param bankRepository
     */
    @Autowired
    public GetBanksListServiceImpl(BankRepository bankRepository) {
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
