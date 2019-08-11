package com.serviceImpl;

import com.entity.Bank;
import com.entity.BankBill;
import com.entity.Product;
import com.entity.User;
import com.repository.BankBillRepository;
import com.repository.BankRepository;
import com.repository.ProductRepository;
import com.repository.UserRepository;
import com.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {

    private Logger LOGGER = LoggerFactory.getLogger(ClaimServiceImpl.class);

    @Autowired
    private ProductRepository repository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BankBillRepository bankBillRepository;
    @Autowired
    BankRepository bankRepository;

    @Override
    public void addProduct(User user, BankBill bankBill, Bank bank) {
        Product product = new Product();
        product.setBankBill(bankBill);
        product.setUser(user);
        product.setBank(bank);
        repository.save(product);
    }

    @Override
    public void addProduct(long userId, long bankBillId, long bankId) {
        BankBill bankBill = bankBillRepository.findDistinctById(bankBillId);
        User user = userRepository.findUserById(userId);
        Bank bank = bankRepository.getOne(bankId);

        addProduct(user, bankBill, bank);

    }

    @Override
    public List<Product> getAllUserProduct(long userId) {
        return repository.findAllByUser_Id(userId);
    }

    @Override
    public Product getProduct(long productId, long userId) {
        return repository.findDistinctByIdAndUser_Id(productId, userId);
    }

    @Override
    public void setFund(long productId, Float fund, long userId) {
        Product product = getProduct(productId, userId);
        product.setAccountFund(product.getAccountFund()+fund);
        repository.save(product);
    }
}
