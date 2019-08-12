package com.controllers;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class RegisterController {

    private final UserRepository userRepository;

    @Autowired
    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/register")
    public String showSignUpForm(User user) {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@Valid User user, BindingResult result, Model model, Principal principal) {
        if (result.hasErrors()) {
            return "index";
        }

        user.setActive(true);
        user.setRole(3);
        userRepository.save(user);
        return "index";
    }
}
