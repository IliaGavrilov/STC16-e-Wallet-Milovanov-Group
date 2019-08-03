package com.entity;

import javax.persistence.*;

@Entity(name = "claim")
public class Claim {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

    public Claim(long productId) {
        this.productId = productId;
    }

    public Claim() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
