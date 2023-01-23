package com.bank.customer.response.entity;

public class CustomerResponse {
    private int cutomerId;
    private String custName;
    private String gender;
    private String mobNo;

    private String bankName;

    public CustomerResponse() {

    }

    public CustomerResponse(int cutomerId, String custName, String gender, String mobNo, String bankName) {
        this.cutomerId = cutomerId;
        this.custName = custName;
        this.gender = gender;
        this.mobNo = mobNo;
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getCutomerId() {
        return cutomerId;
    }

    public void setCutomerId(int cutomerId) {
        this.cutomerId = cutomerId;
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

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "cutomerId=" + cutomerId +
                ", custName='" + custName + '\'' +
                ", gender='" + gender + '\'' +
                ", mobNo='" + mobNo + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
