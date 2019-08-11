package com.controllers;

import com.entity.Accounts;
import com.entity.Product;
import com.repository.UserRepository;
import com.serviceImpl.AccountsServiceImp;
import com.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
//    //@PreAuthorize("hasRole('CLIENT')")
//    @RequestMapping(value = "/profile/accounts/{id}/replenish-account", method = RequestMethod.GET)
////    public ModelAndView replenishForm(@PathVariable Integer id, Principal principal){
//    public ModelAndView replenishForm(@PathVariable Integer id){
//        long testUserId = 1L;
//        Accounts account = accountsServiceImp.getAccountById(Long.valueOf(id));
////        Accounts account = accountsServiceImp.getAccountByIdAndUserId(1l,testUserId );
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("account", account);
//        //modelAndView.addObject("user", accountsServiceImp.getUserById(id));
//        modelAndView.addObject("action", "replenish-account");
//        modelAndView.addObject("formRepl","/profile/accounts/replenish-account");
//        modelAndView.setViewName("replenish-account");
//        return modelAndView;
//    }

    //@PreAuthorize("hasRole('CLIENT')")
//    @RequestMapping(value = "/profile/accounts/replenish-account", method = RequestMethod.POST)
//    public ModelAndView replenishSave(@ModelAttribute Accounts account){
//        accountsServiceImp.addFunds(account);
//        return new ModelAndView("redirect:/bank");
//    }

    //*--------------------------------------


    @Autowired
    ProductServiceImpl productService;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/profile/accounts/{id}/v1")
    public ModelAndView accountV1(@PathVariable String id, Principal principal) {
        ModelAndView modelAndViewAccounts = new ModelAndView();
        //modelAndViewAccounts.addObject("user_accounts", accountsServiceImp.getAllUserAccounts(Long.parseLong(id)));
//        modelAndViewAccounts.addObject("user", accountsServiceImp.getUserById(Long.parseLong(id)));
        modelAndViewAccounts.addObject("user", userRepository.findUserById(1l));
        modelAndViewAccounts.setViewName("accounts_id");
        return modelAndViewAccounts;
    }


    @RequestMapping(value = "/profile/accounts/{id}/replenish-account", method = RequestMethod.GET)
    public ModelAndView replenishForm(@PathVariable Integer id){
        long testUserId = 1L;

        Product product = productService.getProduct(Long.valueOf(id), 1l);
//        Accounts account = accountsServiceImp.getAccountById(Long.valueOf(id));
//        Accounts account = accountsServiceImp.getAccountByIdAndUserId(1l,testUserId );

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

//        accountsServiceImp.addFunds(account);
        return new ModelAndView("redirect:/bank");
    }
}
