package com.service;

import com.entity.BankBill;
import com.entity.Product;
import com.entity.User;

import java.util.List;

public interface ProductService {
    void addProduct(User user, BankBill bankBill);
    void addProduct(long userId, long bankBillId);

    List<Product> getAllUserProduct(long userId);
}
