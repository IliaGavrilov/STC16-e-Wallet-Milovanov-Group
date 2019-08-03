package com.controllers;

import com.entity.BankBill;
import com.services.BankBillCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


@Controller

public class BankBillCreateController {

    @Autowired
    private final BankBillCreate bankBillCreate;

    public BankBillCreateController(BankBillCreate bankBillCreate) {
        this.bankBillCreate = bankBillCreate;
    }

    @RequestMapping("/bankservicecreate")
    public String index(Model model){
        BankBill bankBill = new BankBill();
        model.addAttribute( "bankBill", bankBill);
        return "bankservicecreate";
    }

    /**
     * Создание банковской услуги/счёта
     * @return
     */
    @RequestMapping(value="/bankservicecreate", method = RequestMethod.GET)
    public ModelAndView addService() {
        BankBill bankBill = new BankBill();

        ModelAndView modelAndView = new ModelAndView(  );
        modelAndView.addObject( "bankBill",bankBill );
        modelAndView.addObject( "action", "save" );
        modelAndView.addObject( "formAction", "/bankservicecreate" );
        modelAndView.setViewName( "bankservicecreate" );
        return modelAndView;
    }

    /**
     * Сохранение созданной банковской услуги/счёта
     * @param bankBill - банковский счёт
     * @return к созданию нового счёта, тут стоит решить куда должен быть переход после создания счёта
     */
    @RequestMapping(value = "/bankservicecreate", method = RequestMethod.POST)
    public ModelAndView addServiceSave(@ModelAttribute BankBill bankBill){
        bankBill.setNumberOfBill( new Timestamp( System.currentTimeMillis() ).getTime() );
        bankBillCreate.save( bankBill );
        return new ModelAndView( "/bankservicecreate" );
    }
}

