package com.repository;

import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(long userId);
    List<User> findUserByRole(int userRole);
    User findUserByName(String name);
    List<User> findByName(String name);
    long count();

}
