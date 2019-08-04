package com.controllers;

import com.entity.Product;
import com.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    /**
     * добавление продукта конкретному пользователю
     * @param userId
     * @param bankBillId
     */
    @PostMapping
    public void addProduct(@RequestParam("userId") long userId, @RequestParam("bankBillId") long bankBillId){
        service.addProduct(userId, bankBillId);
    }

    /**
     * Получение всех продуктов пользователя
     * @param userId
     * @return
     */
    @GetMapping
    public String getProductByUserId(@RequestParam("userId") long userId, Model model){

        List<Product> allUserProduct = service.getAllUserProduct(userId);
        model.addAttribute( "allUserProduct", allUserProduct);

        return "product";
    }
}
