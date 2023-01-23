package com.bank.customer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id")
    private int customerId;

    @Column(name="cust_name")
    @NotBlank(message = "Customer name must not be blank")
    @NotNull(message = "Customer name must not be null")
    private String custName;

    @Column(name="gender")
    private String gender;

    @Column(name="mobile_number")
    @Size(min = 10,max = 12,message = "Mobile number should be between 10 to 12")
    private String mobNo;

    @OneToOne(cascade = CascadeType.ALL,fetch =FetchType.LAZY,mappedBy = "customer")
    @JsonManagedReference(value="cust_pan")
    PanCard pancard;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "customer")
    @JsonManagedReference(value="cust_account")
    List<Account> accounts;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="custs_adds",joinColumns = @JoinColumn(name="customer_id"),inverseJoinColumns = @JoinColumn(name="address_id"))
    List<Address> addresses;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public PanCard getPancard() {
        return pancard;
    }

    public void setPancard(PanCard pancard) {
        this.pancard = pancard;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", custName='" + custName + '\'' +
                ", gender='" + gender + '\'' +
                ", mobNo='" + mobNo + '\'' +
                ", pancard=" + pancard +
                ", accounts=" + accounts +
                ", addresses=" + addresses +
                '}';
    }
}
