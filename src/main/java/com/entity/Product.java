package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "userproduct")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bankbill_id")
    private BankBill bankBill;

    @Column(name = "number_of_bill", unique = true)
    public long numberOfBill;

    public Product() {
        this.numberOfBill = setNumberOfBill();
    }

    public Product(User user, BankBill bankBill) {
        this.user = user;
        this.bankBill = bankBill;
        this.numberOfBill = setNumberOfBill();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BankBill getBankBill() {
        return bankBill;
    }

    public void setBankBill(BankBill bankBill) {
        this.bankBill = bankBill;
    }

    public long getNumberOfBill() {
        return numberOfBill;
    }

    public long setNumberOfBill() {
        return new Timestamp( System.currentTimeMillis() ).getTime();
    }
}
