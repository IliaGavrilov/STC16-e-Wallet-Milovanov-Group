package com.controllers;

import com.services.GetBankById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConcreteBankController {

    private GetBankById getBankById;

    /**
     * Autowired Конструктор
     * @param getBankById подключаем сервис для получения данных
     */
    @Autowired
    public ConcreteBankController(GetBankById getBankById) {
        this.getBankById = getBankById;
    }

    /**
     *
     * @param id айди банка из строки запроса
     * @param model модель отображения данных
     * @return переход на вьюшку
     */
    @GetMapping("/bank-list/bank/{id}")
    public String index(@PathVariable String id, Model model) {
        model.addAttribute("bank", getBankById.getBankById(Long.valueOf(id)))
                .addAttribute("bill_types", getBankById.getAllTypesOfBankBill());
        return "concreteBank";
    }

}
