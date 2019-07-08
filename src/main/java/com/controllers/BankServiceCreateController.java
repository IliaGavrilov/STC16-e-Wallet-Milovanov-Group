package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankServiceCreateController {
        @RequestMapping("/BankServiceCreate")
        public String index(){
            return "BankServiceCreate";
        }
}

