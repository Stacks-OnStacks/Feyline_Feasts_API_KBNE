package com.revature.project_1.Users_Payment.DTO.requests;

import com.revature.project_1.Users.User;

import java.util.UUID;

public class NewUPRequest {


    public double balance;
    public String expDate;
    public int ccv;
    public int zipCode;
    public User customerUsername;

    public NewUPRequest(){}

    public NewUPRequest(double balance, String expDate, int ccv, int zipCode) {
        this.balance = balance;
        this.expDate = expDate;
        this.ccv = ccv;
        this.zipCode = zipCode;
        customerUsername=null;
    }



    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public User getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(User customerUsername) {
        this.customerUsername = customerUsername;
    }

    @Override
    public String toString() {
        return "NewUPRequest{" +
                ", balance=" + balance +
                ", expDate='" + expDate + '\'' +
                ", ccv=" + ccv +
                ", zipCode=" + zipCode +
                ", customerUsername=" + customerUsername +
                '}';
    }
}
