package main.java.com.controllers;

@Controller
public class BankServiceCreateController {
        @RequestMapping("/BankServiceCreate")
        public String index(){
            return "BankServiceCreate";
        }
    }
}
