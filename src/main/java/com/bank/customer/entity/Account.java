package com.bank.customer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Account implements Serializable {

    @Id
    @Column(name="account_number")
    private int accountNumber;

    @Column(name="account_type")
    private String accountType;

    @Column(name="bank_name")
    private String bankName;

    @ManyToOne
    @JoinColumn(name="Customer_id")
    @JsonBackReference(value="cust_account")
    private Customer customer;



    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                ", bankName='" + bankName + '\'' +
                ", customer=" + customer +
                '}';
    }
}
