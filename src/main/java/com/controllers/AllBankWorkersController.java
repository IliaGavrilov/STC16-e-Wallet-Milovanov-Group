package com.controllers;

import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllBankWorkersController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/all-bank-workers")
    public String index(Model model){
        model.addAttribute("users", userRepository.findUserByRole(2));
        return "all-bank-workers";
    }
}
