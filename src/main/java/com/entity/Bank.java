package com.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "banks_users",
            joinColumns = @JoinColumn(name = "banks_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    @JsonManagedReference
    private Set<User> users = new HashSet<>();

    public Bank() {
    }

    public Bank(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addUser(User user) {
        users.add(user);
        user.getBanks().add(this);
    }

    public void removeUser(User user) {
        users.remove(user);
        user.getBanks().remove(this);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
