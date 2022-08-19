package com.revature.project_1.Users.DTO.requests;

import java.util.Date;

public class NewUserRequest {


    public String username;
    public String fname;
    public String lname;
    public String password;
    public Date dob;
    private boolean isAdmin;


    public NewUserRequest(){}
    public NewUserRequest(String username, String fname, String lname, String password, Date dob) {

        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.dob = dob;
        this.isAdmin=false;
    }

    public NewUserRequest(String username, String fname, String lname, String password, Date dob, boolean isAdmin) {

        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.dob = dob;
        this.isAdmin = isAdmin;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getFname() {
        return fname;
    }


    public void setFname(String fname) {
        this.fname = fname;
    }


    public String getLname() {
        return lname;
    }


    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "NewRegistrationRequest{" +
                "username='" + username + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", password='" + password + '\'' +
                ", dob=" + dob +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
