package com.controllers;

import com.serviceImpl.GetBanksListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BanksListController {
    /**
     * сервис
     */
    private GetBanksListServiceImpl getBanksList;
    /**
     * Autowired Конструктор
     * @param getBanksList подключаем сервис для получения данных
     */
    @Autowired
    public BanksListController(GetBanksListServiceImpl getBanksList) {
        this.getBanksList = getBanksList;
    }

    /**
     *
     * @param model модель отображения данных
     * @return переход на вьюшку
     */
    @RequestMapping(value = "/bank-list")
    public String index(Model model) {
        model.addAttribute("bankList", getBanksList.getBanks());
        return "listOfBanks";
    }
}
