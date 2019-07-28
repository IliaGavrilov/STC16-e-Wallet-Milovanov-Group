package com.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typeofbankbill")
public class TypeOfBankBill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "typeOfBankBill")
    private List<BankBill> bankBill;

    public List<BankBill> getBankBill() {
        return bankBill;
    }

    public void setBankBill(List<BankBill> bankBill) {
        this.bankBill = bankBill;
    }
}

