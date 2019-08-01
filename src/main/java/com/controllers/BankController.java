package com.controllers;

import com.entity.Bank;
import com.repository.BankRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/bank")
public class BankController {

    private final BankRepository repository;

    public BankController(BankRepository repository) {
        this.repository = repository;
    }
    // TODO убрать index()
    @RequestMapping()
    public String index(){
        return "bank";
    }

    // TODO get из mapping
    @GetMapping("/get")
    public List<Bank> addBank(){
        return repository.findAll();
    }
}
