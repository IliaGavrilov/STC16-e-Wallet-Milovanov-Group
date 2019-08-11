package com.entity;

import javax.persistence.*;

@Entity(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_user")
    private User id_user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "type_of_bank_bill_id")
    private TypeOfBankBill id_typeOfBankBill;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bank_id")
    private Bank bank_id;

    @Column(name = "funds")
    private Float account_fund;

    /**
     * Constructor default and not
     */
    public Accounts() {
    }

    public Accounts(User id_user, TypeOfBankBill id_typeOfBankBill, Bank id_bank, Float account_fund) {
        this.id_user = id_user;
        this.id_typeOfBankBill = id_typeOfBankBill;
        this.bank_id = id_bank;
        this.account_fund = account_fund;
    }

    /**
     * Getters and Setters
     *
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public TypeOfBankBill getId_typeOfBankBill() {
        return id_typeOfBankBill;
    }

    public void setId_typeOfBankBill(TypeOfBankBill id_typeOfBankBill) {
        this.id_typeOfBankBill = id_typeOfBankBill;
    }

    public Float getAccount_fund() {
        return account_fund;
    }

    public void setAccount_fund(Float account_fund) {
        this.account_fund = account_fund;
    }

    public Bank getBank_id() {
        return bank_id;
    }

    public void set_bank_id(Bank bank_id) {
        this.bank_id = bank_id;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", id_typeOfBankBill=" + id_typeOfBankBill +
                ", bank_id=" + bank_id +
                ", account_fund=" + account_fund +
                '}';
    }
}
