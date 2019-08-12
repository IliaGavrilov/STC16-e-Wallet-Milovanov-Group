package com.controllers;

import com.entity.Product;
import com.entity.User;
import com.repository.UserRepository;
import com.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl service;
    @Autowired
    private UserRepository userRepository;

    /**
     * добавление продукта конкретному пользователю
     * @param bankBillId
     */
    @PostMapping
    public void addProduct(Principal principal, @RequestParam("bankBillId") long bankBillId){
        User user = userRepository.findUserByName(principal.getName());
        service.addProduct(user.getId(), bankBillId);
    }

    /**
     * Получение всех продуктов пользователя
     * @return
     */
    @GetMapping
    public String getProductByUserId(Principal principal, Model model){

        User user = userRepository.findUserByName(principal.getName());
        List<Product> allUserProduct = service.getAllUserProduct(user.getId());
        model.addAttribute( "allUserProduct", allUserProduct);

        return "product";
    }
}
