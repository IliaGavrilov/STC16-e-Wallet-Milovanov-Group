package com.entity;

import javax.persistence.*;

@Entity(name = "claim")
public class Claim {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bankbill_id")
    private BankBill bankBill;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status = StatusEnum.In_Question;

	public enum StatusEnum{Accept, In_Question, Negative}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

    public Claim(){}

    public Claim(BankBill bankBill) {
        this.bankBill = bankBill;
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

    public BankBill getBankBill() {
        return bankBill;
    }

    public void setBankBill(BankBill bankBillId) {
        this.bankBill = bankBillId;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
