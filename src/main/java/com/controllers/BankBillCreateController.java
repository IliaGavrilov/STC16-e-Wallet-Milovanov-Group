package com.controllers;

import com.entity.Bank;
import com.entity.BankBill;
import com.entity.TypeOfBankBill;
import com.repository.BankBillTypeRepository;
import com.repository.BankRepository;
import com.serviceImpl.QuickSortingServiceImpl;
import com.serviceImpl.BankBillCreateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.List;


@Controller

public class BankBillCreateController {

    @Autowired
    private BankBillCreateImpl bankBillCreateImpl;

    @Autowired
    private QuickSortingServiceImpl sortingService;

    @Autowired
    private BankBillTypeRepository bankBillTypeRepository;

    @Autowired
    private BankRepository bankRepository;

    public BankBillCreateController(BankBillCreateImpl bankBillCreateImpl) {
        this.bankBillCreateImpl = bankBillCreateImpl;
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
        TypeOfBankBill typeOfBankBill = new TypeOfBankBill();
        Bank bank = new Bank();
        List<TypeOfBankBill> typeOfBankBillList = bankBillTypeRepository.findAll();
        List<Bank> banks = bankRepository.findAll();

        ModelAndView modelAndView = new ModelAndView(  );
        modelAndView.addObject( "bankBill",bankBill );
        modelAndView.addObject( "typeOfBankBill", typeOfBankBill );
        modelAndView.addObject( "bank", bank );
        modelAndView.addObject( "banks", banks );
        modelAndView.addObject( "typeOfBankBillList", typeOfBankBillList );
        modelAndView.addObject( "action", "save" );
        modelAndView.addObject( "formAction", "/bankservicecreate" );
        modelAndView.setViewName( "bankservicecreate" );
        return modelAndView;
    }

    /**
     * Сохранение созданной банковской услуги/счёта
     * @param bankBill - банковский счёт
     * @return окно создания нового счёта
     */
    @RequestMapping(value = "/bankservicecreate", method = RequestMethod.POST)
    public ModelAndView addServiceSave(@ModelAttribute BankBill bankBill){
        bankBillCreateImpl.save( bankBill );
        return new ModelAndView( "/bankservicecreate" );
    }

    /**
     * получить список банковских услуг с сортировкой
     * по умолчанию сортировка ASC
     * @param model
     * @param sort
     * @param field
     * @return
     */
    @GetMapping("/bankbill/list")
    public String getBankBillSortList(Model model, @RequestParam(value="sort", required=false, defaultValue="ASC") String sort,
                                      @RequestParam(value="field", required=false, defaultValue="id") String field){

        model.addAttribute("bankBillList", sortingService.findAllWithSort(sort, field));
        return "bankBillList";
    }
}

