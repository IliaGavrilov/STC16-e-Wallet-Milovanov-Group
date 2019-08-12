package com.controllers;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class AdminController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/admin")
    public String index(Principal principal, Model model){
        model.addAttribute("user", principal.getName());
        User loggedUser = userRepository.findUserByName(principal.getName());
        model.addAttribute("userId", loggedUser.getId());
        return "admin";
    }
}
