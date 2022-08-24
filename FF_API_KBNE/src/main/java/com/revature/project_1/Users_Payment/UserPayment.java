package com.revature.project_1.Users_Payment;

public class UserPayment {

    public String paymentId;
    public double balance;
    public String expDate;
    public int ccv;
    public int zipCode;
    public String customerUsername;

    public UserPayment( double balance, String expDate, int ccv, int zipCode, String customerUsername) {
        this.balance = balance;
        this.expDate = expDate;
        this.ccv = ccv;
        this.zipCode = zipCode;
        this.customerUsername = customerUsername;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }
}
