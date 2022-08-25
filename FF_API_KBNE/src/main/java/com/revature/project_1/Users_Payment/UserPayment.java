package com.revature.project_1.Users_Payment;

import com.revature.project_1.Users.User;
import com.revature.project_1.Users_Payment.DTO.requests.EditUPRequest;

import javax.persistence.*;

@Entity(name = "userpayments")
@Table(name = "userpayments")
public class UserPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    public int paymentId;
    @Column(name = "balance")
    public double balance;
    @Column(name = "expDate")
    public String expDate;
    @Column(name = "ccv")
    public int ccv;
    @Column(name = "zipCode")
    public int zipCode;

    @ManyToOne
    @JoinColumn(name = "username")
    public User customerUsername;


    public UserPayment(){}

    public UserPayment( double balance, String expDate, int ccv, int zipCode, User customerUsername) {
        this.balance = balance;
        this.expDate = expDate;
        this.ccv = ccv;
        this.zipCode = zipCode;
        this.customerUsername = customerUsername;
    }

    public UserPayment(EditUPRequest userPay) {
        this.balance = balance;
        this.expDate = expDate;
        this.ccv = ccv;
        this.zipCode = zipCode;
        this.customerUsername = customerUsername;
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
}
