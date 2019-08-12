package com.controllers;

import com.repository.BankBillRepository;
import com.serviceImpl.GetBankByIdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConcreteBankController {
    /**
     * сервис
     */
    private GetBankByIdServiceImpl getBankById;
    private BankBillRepository bankBillRepository;

    /**
     * Autowired Конструктор
     * @param getBankById подключаем сервис для получения данных
     */
    @Autowired
    public ConcreteBankController(GetBankByIdServiceImpl getBankById, BankBillRepository bankBillRepository) {
        this.getBankById = getBankById;
        this.bankBillRepository = bankBillRepository;
    }

    /**
     *
     * @param id айди банка из строки запроса
     * @param model модель отображения данных
     * @return переход на вьюшку
     */
    @GetMapping("/bank-list/bank/{id}")
    public String index(@PathVariable String id, Model model) {
        model.addAttribute("bank", getBankById.getBankById(Long.parseLong(id)));
        return "concreteBank";
    }

}
