package com.controllers;

import com.services.GetBanksList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BanksListController {

    private GetBanksList getBanksList;

    @Autowired
    public BanksListController(GetBanksList getBanksList) {
        this.getBanksList = getBanksList;
    }

    @RequestMapping(value = "/bank-list")
    public String index(Model model) {
        model.addAttribute("bankList", getBanksList.getBanks());
        return "listOfBanks";
    }
}
