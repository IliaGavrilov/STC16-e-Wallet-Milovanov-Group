package com.controllers;

import com.entity.Product;
import com.repository.UserRepository;
import com.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class AccountsController {
    /**
     * сервис
     */
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/profile/accounts/{id}")
    public ModelAndView accountV1(@PathVariable String id, Principal principal) {
        ModelAndView modelAndViewAccounts = new ModelAndView();
        modelAndViewAccounts.addObject("user", userRepository.findUserById(1l));
        modelAndViewAccounts.setViewName("accounts_id");
        return modelAndViewAccounts;
    }

    /**
     * Форма добавления средств
     * */
    @RequestMapping(value = "/profile/accounts/{id}/replenish-account", method = RequestMethod.GET)
    public ModelAndView replenishForm(@PathVariable Integer id){
        Product product = productService.getProduct(Long.valueOf(id), 1l);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("account", product);
        //modelAndView.addObject("user", accountsServiceImp.getUserById(id));
        modelAndView.addObject("action", "replenish-account");
        modelAndView.addObject("formRepl","/profile/accounts/replenish-account");
        modelAndView.setViewName("replenish-account");
        return modelAndView;
    }

    @RequestMapping(value = "/profile/accounts/replenish-account", method = RequestMethod.POST)
    public ModelAndView replenishSave(@RequestParam("id") long productId, @RequestParam("accountFund") Float accountFund){
        long testUserId = 1L;
        productService.setFund(productId,accountFund, testUserId);
        return new ModelAndView("redirect:/bank");
    }
}
