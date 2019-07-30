package com.controllers;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

//import entity.User;

@Controller
@RequestMapping("/edit-profile")
public class EditProfileController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
//    @RequestMapping("/profile")
    //@RequestMapping(value="/profile", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
    public String index(Model model){
//    public ModelAndView showCabinet(Principal principal) {
//        List<User> ingredients = Arrays.asList(
//                new User(1,1, "Max", "admin@admin.ru", "1", true),
//                new User(2,2, "Elena", "Elena@bank.ru", "2", true),
//                new User(3,3, "Alex", "Alex@home.ru", "3", true)
//        );

        //User user = new User(1,1, "Max", "admin@admin.ru", "1", true);

//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("profile/index");
        model.addAttribute("user", new User("Alex", "Alex@home.ru", "3"));
        // TODO запрос к БД для получения полей юзера
        return("edit-profile");
//        return modelAndView;
    }

    @PostMapping
    public String processOrder(@Valid User user, Errors errors) {
//        if (errors.hasErrors()) {
//            return "error";
//        }
        return "edit-profile";
    }
}
