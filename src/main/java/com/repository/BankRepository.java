package com.repository;

import com.entity.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {
    @Override
    List<Bank> findAll();
}
