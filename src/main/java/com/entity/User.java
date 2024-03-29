package com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private int role;
    private String name;
    private String email;
    private String password;
    private boolean active;

    @ManyToMany(mappedBy = "users")
    @JsonBackReference
    private Set<Bank> banks = new HashSet<>();

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.MERGE,
            orphanRemoval = true)
    private List<Product> products;

    public Set<Bank> getBanks() {
        return banks;
    }

    public void setBanks(Set<Bank> banks) {
        this.banks = banks;
    }

//    public List<Accounts> getAccounts() {
//        return accounts;
//    }
    public List<Product> getProducts() {
        return products;
    }

    public void setAccounts(List<Product> products) {
        this.products = products;
    }

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = hashPassword(password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(12);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return(hashed_password);
    }
}
