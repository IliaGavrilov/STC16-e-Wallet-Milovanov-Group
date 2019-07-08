package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BankController {
    @RequestMapping("/bank")
    public String index(){
        return "bank";
    }
}
