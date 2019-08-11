package com.repository;

import com.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {
    List<Accounts> findAllById(long userId);

    Accounts findDistinctByIdAndId_user(long accountsId, long userId);
    
}
