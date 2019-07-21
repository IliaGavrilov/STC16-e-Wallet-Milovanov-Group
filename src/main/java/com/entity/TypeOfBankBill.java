package com.entity;


import javax.persistence.*;

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

    @OneToOne(optional = false, mappedBy = "typeOfBankBill")
    private BankBill bankBill;

    public BankBill getBankBill() {
        return bankBill;
    }

    public void setBankBill(BankBill bankBill) {
        this.bankBill = bankBill;
    }
}

