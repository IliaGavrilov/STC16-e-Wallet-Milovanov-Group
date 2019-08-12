package com.controllers;

import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllClientsController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/all-clients")

    public String index(Model model){

        model.addAttribute("users", userRepository.findUserByRole(3));
        return "all-clients";
    }
}
