package com.controllers;
import com.entity.Claim;
import com.entity.User;
import com.repository.ClaimRepository;
import com.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/claim")
public class ClaimController {

    private final ClaimRepository repository;
    private final UserRepository userRepository;

    public ClaimController(ClaimRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }


    // TODO @PostMapping with @RequestParam int userId, @RequestParam int productId
    @GetMapping("/add_test")
    public List<Claim> addAClaim(){
        User userTest = new User("Name User", "test@mail.ru", "pass");
        int userId = 1;
        int productId = 11;

        userRepository.save(userTest);
        Iterable<User> all = userRepository.findAll();
        User user = userRepository.findUserById(userId);
        Claim claim = new Claim( productId);
        claim.setUser(user);
        repository.save(claim);

        return repository.findAllByUser(user);
    }
}
