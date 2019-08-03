package com.entity;

import javax.persistence.*;

@Entity(name = "claim")
public class Claim {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "bankbill_id")
    private long bankBillId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status = StatusEnum.In_Question;

    private enum StatusEnum{Accept, In_Question, Negative}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;


    public Claim(long bankBillId) {
        this.bankBillId = bankBillId;
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

    public long getbankBillId() {
        return bankBillId;
    }

    public void setbankBillId(long bankBillId) {
        this.bankBillId = bankBillId;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
