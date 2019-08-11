package com.service;

import com.entity.Bank;
import com.entity.BankBill;
import com.entity.Product;
import com.entity.User;

import java.util.List;

public interface ProductService {
    void addProduct(User user, BankBill bankBill, Bank bank);
    void addProduct(long userId, long bankBillId, long bankId);

    List<Product> getAllUserProduct(long userId);
    Product getProduct(long productId, long userId);
    void setFund(long productId, Float fund, long userId);
}
