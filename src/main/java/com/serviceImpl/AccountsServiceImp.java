package com.serviceImpl;

import com.entity.Accounts;
import com.entity.User;
import com.repository.AccountsRepository;
import com.repository.BankBillTypeRepository;
import com.repository.UserRepository;
import com.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImp implements AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private BankBillTypeRepository bankBillTypeRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Accounts addFunds(Accounts account) {
        account = accountsRepository.save(account);
        return account;
    }

    public void addSum(int id, int sum) {
    }

    @Override
    public Accounts getAccountById(Long id) {
        return accountsRepository.findById(id).get();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findUserById(id);
    }

//    @Override
//    public Accounts getAccountByIdAndUserId(long accountsId, long userId) {
//        return accountsRepository.findDistinctByIdAndId_user(accountsId, userId);
//    }
}
