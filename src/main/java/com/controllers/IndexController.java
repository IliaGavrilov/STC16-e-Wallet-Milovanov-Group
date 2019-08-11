package com.controllers;

import com.serviceImpl.GetBankByIdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    /**
     * сервис
     */
    private GetBankByIdServiceImpl getBankById;

    /**
     * Autowired Конструктор
     * @param getBankById подключаем сервис для получения данных
     */
    @Autowired
    public IndexController(GetBankByIdServiceImpl getBankById) {
        this.getBankById = getBankById;
    }

    @RequestMapping(value = {"/", "/index.html", "/index"})
    public ModelAndView index(Model model) {
        ModelAndView modelAndViewIndex = new ModelAndView();
        modelAndViewIndex.addObject("bill_types", getBankById.getAllTypesOfBankBill());
        modelAndViewIndex.setViewName("index");
        return modelAndViewIndex;
    }
}
