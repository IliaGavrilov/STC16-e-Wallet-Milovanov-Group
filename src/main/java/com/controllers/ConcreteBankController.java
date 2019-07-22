package com.controllers;

import com.entity.Bank;
import com.services.GetBankByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConcreteBankController {

    private GetBankByIdService gbbis;
    private Bank bank;

    @Autowired
    public ConcreteBankController(GetBankByIdService gbbis) {
        this.gbbis = gbbis;
    }


    //добавить реквест параметр по id
    @GetMapping("/bank/{id}")
    @ResponseBody
    public String index(@PathVariable String id, Model model) {
        model.addAttribute("bank",gbbis.getBankById(Long.valueOf(id)))
                .addAttribute("billType",gbbis.getAllTypesOfBankBill());
        return "concreteBank";
    }

}
