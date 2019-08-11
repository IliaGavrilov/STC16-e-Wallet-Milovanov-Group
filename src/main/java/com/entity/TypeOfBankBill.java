package com.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typeofbankbill")
public class TypeOfBankBill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;
    @Column(name = "title")
    public String title;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "typeOfBankBill")
    private List<BankBill> bankBill;

    @OneToMany(mappedBy = "id_typeOfBankBill", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Accounts> accounts;

    public List<BankBill> getBankBill() {
        return bankBill;
    }

    public void setBankBill(List<BankBill> bankBill) {
        this.bankBill = bankBill;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }
}

