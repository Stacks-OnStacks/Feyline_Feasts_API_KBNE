package com.revature.project_1.Users_Payment.DTO.response;

import com.revature.project_1.Users.User;
import com.revature.project_1.Users_Payment.UserPayment;


public class UPResponse {

    public int paymentId;
    public double balance;
    public String expDate;
    public int ccv;
    public int zipCode;
    public User customerUsername;


    public UPResponse() {
    }

    public UPResponse(int paymentId, double balance, String expDate, int ccv, int zipCode, User customerUsername) {
        this.paymentId = paymentId;
        this.balance = balance;
        this.expDate = expDate;
        this.ccv = ccv;
        this.zipCode = zipCode;
        this.customerUsername = customerUsername;
    }

    public UPResponse(UserPayment userPay) {
        this.paymentId = userPay.paymentId;
        this.balance = userPay.balance;
        this.expDate = userPay.expDate;
        this.ccv = userPay.ccv;
        this.zipCode = userPay.zipCode;
        this.customerUsername = userPay.customerUsername;

    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
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

    public User getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(User customerUsername) {
        this.customerUsername = customerUsername;
    }

    @Override
    public String toString() {
        return "UPResponse{" +
                "paymentId='" + paymentId + '\'' +
                ", balance=" + balance +
                ", expDate='" + expDate + '\'' +
                ", ccv=" + ccv +
                ", zipCode=" + zipCode +
                ", customerUsername=" + customerUsername +
                '}';
    }
}
