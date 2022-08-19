package com.revature.project_1.Users_Payment.DTO.requests;

import com.revature.project_1.Users.User;
import com.revature.project_1.util.web.DTO.EditResourceRequest;

public class EditUPRequest extends EditResourceRequest {

    public String paymentId=super.getId();
    public double balance;
    public String expDate;
    public int ccv;
    public int zipCode;
    public User customerUsername;

    public EditUPRequest()
    {
        super();

    }

    @Override
    public String toString() {
        return "EditUPRequests{" +
                "paymentId='" + paymentId + '\'' +
                ", balance=" + balance +
                ", expDate='" + expDate + '\'' +
                ", ccv=" + ccv +
                ", zipCode=" + zipCode +
                ", customerUsername='" + customerUsername + '\'' +
                '}';
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

    public User getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(User customerUsername) {
        this.customerUsername = customerUsername;
    }
}
