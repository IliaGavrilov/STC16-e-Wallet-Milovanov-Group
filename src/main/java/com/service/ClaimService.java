package com.service;

import com.entity.BankBill;
import com.entity.Claim;
import com.entity.User;

import java.util.List;

public interface ClaimService {
    void addClaim(User user, long productId);
    void addClaim(long userId, long productId);

    Claim getClaimById(long id);

    List<BankBill> getAllBills();

    List<Claim> getAllUserClaims(User user);
    List<Claim> getAllUserClaims(long userId);

    void removeClaimById(int id);
}
