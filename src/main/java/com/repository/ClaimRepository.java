package com.repository;

import com.entity.Claim;
import com.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, Long> {
    Claim findAllById(Long id);

    List<Claim> findAllByUser(User user);
}
