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

    @RequestMapping(value = "/profile/accounts")
    public ModelAndView account(Principal principal) {
        ModelAndView modelAndViewAccounts = new ModelAndView();
        modelAndViewAccounts.addObject("user", userRepository.findUserByName(principal.getName()));
        modelAndViewAccounts.setViewName("accounts_id");
        return modelAndViewAccounts;
    }

    /**
     * Форма добавления средств
     * */
    @RequestMapping(value = "/profile/accounts/{id}/replenish-account", method = RequestMethod.GET)
    public ModelAndView replenishForm(@PathVariable Integer id, Principal principal){
        Product product = productService.getProduct(Long.valueOf(id), userRepository.findUserByName(principal.getName()).getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("account", product);
        //modelAndView.addObject("user", accountsServiceImp.getUserById(id));
        modelAndView.addObject("action", "replenish-account");
        modelAndView.addObject("formRepl","/profile/accounts/replenish-account");
        modelAndView.setViewName("replenish-account");
        return modelAndView;
    }

    @RequestMapping(value = "/profile/accounts/replenish-account", method = RequestMethod.POST)
    public ModelAndView replenishSave(@RequestParam("id") long productId,
                                      @RequestParam("accountFund") Float accountFund,
                                      Principal principal){
        productService.setFund(productId,accountFund, userRepository.findUserByName(principal.getName()).getId());
        return new ModelAndView("redirect:/profile/accounts");
    }
}
