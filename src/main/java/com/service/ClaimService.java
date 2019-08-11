package com.service;

import com.entity.BankBill;
import com.entity.Claim;
import com.entity.User;

import java.util.List;

public interface ClaimService {
    void addClaim(User user, BankBill productId);
    void addClaim(long userId, BankBill productId);

    Claim getClaimById(long id);

    List<BankBill> getAllBills();

    List<Claim> getAllUserClaims(User user);

    List<Claim> getAllUserClaims(long userId);

	public List<Claim> getAllByStatus(Claim.StatusEnum status);

    void removeClaimById(int id);
}
