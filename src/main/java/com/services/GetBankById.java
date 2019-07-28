package com.services;

import com.entity.Bank;
import com.entity.TypeOfBankBill;
import com.repository.BankBillTypeRepository;
import com.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBankById {
    /**
     * BankRepository, BankBillTypeRepository - spring jpa репозитории
     */
    private final BankRepository bankRepository;
    private final BankBillTypeRepository bankBillTypeRepository;

    /**
     * Конструктор с подключением репозиториев через инъекцию Autowired
     * @param bankRepository репозиторий класса Bank
     * @param bankBillTypeRepository репозиторий класса bankBillType
     */
    @Autowired
    public GetBankById(BankRepository bankRepository, BankBillTypeRepository bankBillTypeRepository) {
        this.bankRepository = bankRepository;
        this.bankBillTypeRepository = bankBillTypeRepository;
    }

    /**
     * getBankById - возврат банка через айди
     * @param id входящий параметр id банка
     * @return возвращаем объект типа Bank с указанным айди
     */
    public Bank getBankById(Long id) {
        return bankRepository.findById(id).get();
    }

    /**
     * getAllTypesOfBankBill
     * @return возвращаем список объектов тип банковского счета
     */
    public List<TypeOfBankBill> getAllTypesOfBankBill(){
        return bankBillTypeRepository.findAll();
    }
}
