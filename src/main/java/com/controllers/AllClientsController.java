package com.controllers;

//import com.entity.User;

import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

//import java.util.List;

@Controller
public class AllClientsController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/all-clients")
    //@RequestMapping(value="/all-clients", method = RequestMethod.GET)
    //@GetMapping("/all-clients")
    //@ModelAttribute("users")
    //public ModelAndView ShowAllClients(){
    public String index(Model model){
        //ModelAndView modelAndView = new ModelAndView();
        //Iterable<User> users = userRepository.findAll();
        //modelAndView.addObject("users", userRepository.findAll());
        //modelAndView.addObject("users", users);

        //model.addAttribute("users", userRepository.findAll());
        model.addAttribute("users", userRepository.findUserByRole(3));

        //modelAndView.setViewName("category/list");
        //return modelAndView;
        return "all-clients";
    }
}
