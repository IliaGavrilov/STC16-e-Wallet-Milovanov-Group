package com.controllers;

import com.entity.Bank;
import com.entity.BankBill;
import com.repository.BankBillRepository;
import com.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/bank")
public class BankController {

    private final BankRepository repository;

    @Autowired
    BankBillRepository bankBillRepository;

    public BankController(BankRepository repository) {
        this.repository = repository;
    }
    // TODO убрать index()
    @GetMapping()
    public String index(Model model){
        model.addAttribute("bankBill", new BankBill() );
        model.addAttribute("bankbills", bankBillRepository.findAll());
        return "bank";
    }

    // TODO get из mapping
    @GetMapping("/get")
    public List<Bank> addBank(){
        return repository.findAll();
    }
}
