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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @Column(name = "funds")
    public Float accountFund;

    public Product() {
        this.numberOfBill = setNumberOfBill();
        this.accountFund = setAccountFundDefault();
    }

    public Product(User user, BankBill bankBill, Bank bank) {
        this.user = user;
        this.bankBill = bankBill;
        this.bank = bank;
        this.numberOfBill = setNumberOfBill();
        this.accountFund = setAccountFundDefault();
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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Float getAccountFund() {
        return this.accountFund;
    }

    public void setAccountFund(Float accountFund) {
        this.accountFund = accountFund;
    }

    public Float setAccountFundDefault() {
        return 0.0f;
    }
}
