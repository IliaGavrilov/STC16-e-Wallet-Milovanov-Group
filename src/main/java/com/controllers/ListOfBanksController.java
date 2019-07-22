package com.controllers;

import com.entity.Bank;
import com.services.GetBankListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListOfBanksController {

    private GetBankListService gbls;
    private Bank bank;

    @Autowired
    public ListOfBanksController(GetBankListService gbls) {
        this.gbls = gbls;
    }

    @RequestMapping(value = "/bank-list")
    public String index(Model model) {
        model.addAttribute("bankList", gbls.getBank());
        return "listOfBanks";
    }
}
