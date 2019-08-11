package com.service;

import com.entity.Accounts;
import com.entity.User;

public interface AccountsService {
    Accounts addFunds(Accounts account);
    Accounts getAccountById(Long id);
    User getUserById(long id);

//    Accounts getAccountByIdAndUserId(long accountsId, User user);
}
