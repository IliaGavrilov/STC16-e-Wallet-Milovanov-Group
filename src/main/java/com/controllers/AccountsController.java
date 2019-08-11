package com.controllers;

import com.entity.Accounts;
import com.serviceImpl.AccountsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class AccountsController {
    /**
     * сервис
     */
    @Autowired
    private AccountsServiceImp accountsServiceImp;

    //@PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
    @RequestMapping(value = "/profile/accounts/{id}")
    public ModelAndView account(@PathVariable String id, Principal principal) {
        ModelAndView modelAndViewAccounts = new ModelAndView();
        //modelAndViewAccounts.addObject("user_accounts", accountsServiceImp.getAllUserAccounts(Long.parseLong(id)));
        modelAndViewAccounts.addObject("user", accountsServiceImp.getUserById(Long.parseLong(id)));
        modelAndViewAccounts.setViewName("accounts_id");
        return modelAndViewAccounts;
    }

    /**
     * Форма добавления средств
     * */
    //@PreAuthorize("hasRole('CLIENT')")
    @RequestMapping(value = "/profile/accounts/{id}/replenish-account", method = RequestMethod.GET)
    public ModelAndView replenishForm(@PathVariable Integer id){
        Accounts account = accountsServiceImp.getAccountById(Long.valueOf(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("account", account);
        //modelAndView.addObject("user", accountsServiceImp.getUserById(id));
        modelAndView.addObject("action", "replenish-account");
        modelAndView.addObject("formRepl","/profile/accounts/replenish-account");
        modelAndView.setViewName("replenish-account");
        return modelAndView;
    }

    //@PreAuthorize("hasRole('CLIENT')")
    @RequestMapping(value = "/profile/accounts/replenish-account", method = RequestMethod.POST)
    public ModelAndView replenishSave(@ModelAttribute Accounts account){
        accountsServiceImp.addFunds(account);
        return new ModelAndView("redirect:/bank");
    }

}
