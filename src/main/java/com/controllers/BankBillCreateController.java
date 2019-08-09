package com.controllers;

import com.entity.BankBill;
import com.serviceImpl.QuickSortingServiceImpl;
import com.serviceImpl.BankBillCreateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class BankBillCreateController {

    @Autowired
    private final BankBillCreateImpl bankBillCreateImpl;

    @Autowired
    private QuickSortingServiceImpl sortingService;

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

