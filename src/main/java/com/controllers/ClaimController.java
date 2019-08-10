package com.controllers;

import com.entity.BankBill;
import com.entity.Claim;
import com.entity.User;
import com.repository.BankBillRepository;
import com.repository.UserRepository;
import com.serviceImpl.ClaimServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/claim")
public class ClaimController {

    @Autowired
    ClaimServiceImpl service;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BankBillRepository bankBillRepository;


    @GetMapping("/index")
    public String index(){
        return "client";
    }

    // TODO вытаскивать пользователя из сессии
    //удалить дефолтное значение
    @PostMapping()
//    public void createClaim(@RequestParam("userId") int userId, @RequestParam("bankBillId") int productId){
    public String  createClaim( Principal principal, @RequestParam("bankBillId") long productId){
        //дефолтное значение
        long userId =1l;
        productId = 1l;
        User user = userRepository.findUserById(userId);
        BankBill bankBill = bankBillRepository.findDistinctById(productId);
        service.addClaim(user, bankBill);
        return "claimApply";
    }

    @GetMapping("/all")
    public String addClaimIndex(Model model){
        model.addAttribute("bankBillList", service.getAllBills());
        return "bankBillList";
    }

    // TODO добавить проверку на права доступа
    // т.е. не каждый пользователь может с помощью этого запроса увидеть
    // список запросов другого пользователя
    @GetMapping
//    public List<Claim> getAllUserClaims(Principal principal){
    public List<Claim> getAllUserClaims(@RequestParam("userId") long userId){
        //дефолтное значение
        userId =1l;

        return service.getAllUserClaims(userId);
    }

    @GetMapping("/{id}")
    public Claim getClaim(@PathVariable long id){
        return service.getClaimById(id);
    }

    @PostMapping("/remove")
    public void removeClaim(@RequestParam("id") int id){
        service.removeClaimById(id);
    }
}
