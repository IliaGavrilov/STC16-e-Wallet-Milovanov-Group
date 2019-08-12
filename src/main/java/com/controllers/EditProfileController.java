package com.controllers;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequestMapping("/edit-profile")
public class EditProfileController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'BANK')")
    public String index(Principal principal, Model model){
        model.addAttribute("user",userRepository.findUserByName(principal.getName()));
        return("edit-profile");
    }

    @PostMapping()
    public String updateUser(Principal principal, String name, String email, String password,  Model model) {
        User user = userRepository.findUserByName(principal.getName());
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        model.addAttribute("user", user);
        return("edit-profile");
    }
    
}
