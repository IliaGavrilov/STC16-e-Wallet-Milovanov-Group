package com.entity;


import javax.persistence.*;

@Entity
@Table(name = "bankbill")
public class BankBill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
/*    @Column(name = "id_type_of_bank_bill")
    public Long type;*/
    @Column(name = "name")
    public String name;
    @Column(name = "number_of_bill", unique = true)
    public int numberOfBill;
    @Column (name = "percent_rate")
    public float percentRate;
    @Column (name = "validity")
    public long validity;
    @Column(name = "description")
    public String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_type_of_bank_bill")
    private TypeOfBankBill typeOfBankBill;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

/*    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }*/

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

    public TypeOfBankBill getTypeOfBankBill() {
        return typeOfBankBill;
    }

    public void setTypeOfBankBill(TypeOfBankBill typeOfBankBill) {
        this.typeOfBankBill = typeOfBankBill;
    }

    public int getNumberOfBill() {
        return numberOfBill;
    }

    public void setNumberOfBill(int numberOfBill) {
        this.numberOfBill = numberOfBill;
    }

    public float getPercentRate() {
        return percentRate;
    }

    public void setPercentRate(float percentRate) {
        this.percentRate = percentRate;
    }

    public long getValidity() {
        return validity;
    }

    public void setValidity(long validity) {
        this.validity = validity;
    }

}
