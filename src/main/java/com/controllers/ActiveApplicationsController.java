package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActiveApplicationsController {
    @RequestMapping("/active-applications/test")
    public String index(){
        return "active-applications";
    }
}
