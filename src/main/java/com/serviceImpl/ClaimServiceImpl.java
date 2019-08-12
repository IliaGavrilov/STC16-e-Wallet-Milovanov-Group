package com.serviceImpl;

import com.entity.BankBill;
import com.entity.Claim;
import com.entity.User;
import com.repository.BankBillRepository;
import com.repository.ClaimRepository;
import com.repository.UserRepository;
import com.service.ClaimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    private Logger LOGGER = LoggerFactory.getLogger(ClaimServiceImpl.class);

    @Autowired
    private ClaimRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BankBillRepository bankBillRepository;

    @Override
    public void addClaim(User user, BankBill productId) {
        Claim claim = new Claim(productId);
        claim.setUser(user);
        repository.save(claim);
    }

    @Override
    public void addClaim(long userId, long bankBillId) {
        User user = userRepository.findUserById(userId);
        BankBill bankBill = bankBillRepository.findDistinctById( bankBillId );
        if(user !=null){
            addClaim(user, bankBill);
        }else{
            LOGGER.error("user with id = "+userId+" not found");
        }
    }

    @Override
    public Claim getClaimById(long id){
        Claim claim= repository.findClaimById(id);
        if(claim == null) {
            LOGGER.error("claim with id = " + id + " not found");
        }
        return claim;
    }

    @Override
    public List<Claim> getAllUserClaims(User user) {
        return repository.findAllByUser(user);
    }

    @Override
    public List<Claim> getAllUserClaims(long userId) {
        User user = userRepository.findUserById(userId);
        if(user !=null){
            return getAllUserClaims(user);
        }else{
            LOGGER.error("user with id = "+userId+" not found");
        }
        return null;
    }

    @Override
    public void removeClaimById(long id){
        Claim claim = repository.findClaimById(id);
        if(claim !=null){
            repository.delete(claim);
        }else{
            LOGGER.error("claim with id = "+id+" not found");
        }
    }

    @Override
    public List<BankBill> getAllBills() {
        return bankBillRepository.findAll();
    }

    public List<Claim> findAll(){
        return repository.findAll();
    }

    @Override
    public List<Claim> getAllByStatus(Claim.StatusEnum status){
        return repository.findAllByStatus(status);
    }
}