package com.repository;

import com.entity.Claim;
import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    Claim findClaimById(long id);

    List<Claim> findAllByUser(User user);

    List<Claim> findAllByStatus(Claim.StatusEnum status);
}
