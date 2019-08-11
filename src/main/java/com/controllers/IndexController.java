package com.controllers;

import com.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private BankBillTypeRepository bankBillTypeRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BankBillRepository bankBillRepository;


    @RequestMapping(value = {"/", "/index.html", "/index"})
    public String index(Model model) {
        List<Long> userData = new ArrayList<Long>();
        userData.add(userRepository.count());
        userData.add((long)(productRepository.countUniqueUserProducts()*100.0/userRepository.count()+0.5));
        userData.add(claimRepository.count());
        model.addAttribute("userData", userData);

        List<Long> bankData = new ArrayList<Long>();
        bankData.add(bankBillTypeRepository.count());
        bankData.add(bankRepository.count());
        bankData.add(bankBillRepository.count());
        model.addAttribute("bankData", bankData);

        //List<String> accountData = new ArrayList<>();
        //accountData.addAll(bankBillTypeRepository.getAllBankBills());
        model.addAttribute("accountData", bankBillTypeRepository.findAll());
        return "index";
    }
}
