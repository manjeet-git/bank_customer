package com.bank.customer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class PanCard implements Serializable {

    @Id
    @Column(name="pan_number")
    private String panNumber;

    @Column(name="holder_dob")
    private String holderDOB;

    @Column(name="issued_date")
    private String issuedDate;

    @OneToOne
    @JoinColumn(name="customer_id")
    @JsonBackReference(value="cust_pan")
    private Customer customer;

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getHolderDOB() {
        return holderDOB;
    }

    public void setHolderDOB(String holderDOB) {
        this.holderDOB = holderDOB;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "PanCard{" +
                "panNumber='" + panNumber + '\'' +
                ", HolderDOB='" + holderDOB + '\'' +
                ", issuedDate='" + issuedDate + '\'' +
                ", customer=" + customer +
                '}';
    }
}
