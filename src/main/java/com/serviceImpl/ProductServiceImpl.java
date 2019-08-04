package com.serviceImpl;

import com.entity.BankBill;
import com.entity.Product;
import com.entity.User;
import com.repository.BankBillRepository;
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

    @Override
    public void addProduct(User user, BankBill bankBill) {
        Product product = new Product();
        product.setBankBill(bankBill);
        product.setUser(user);
        repository.save(product);
    }

    @Override
    public void addProduct(long userId, long bankBillId) {
        BankBill bankBill = bankBillRepository.findDistinctById(bankBillId);
        User user = userRepository.findUserById(userId);
        addProduct(user, bankBill);

    }

    @Override
    public List<Product> getAllUserProduct(long userId) {
        return repository.findAllByUser_Id(userId);
    }
}
