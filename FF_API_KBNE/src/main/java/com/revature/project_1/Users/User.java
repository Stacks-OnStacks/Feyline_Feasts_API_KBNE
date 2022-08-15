package com.revature.project_1.Users;

import java.util.Date;

public class User {

    public String username;
    public String fname;
    public String lname;
    public String password;
    public Date dob;
    private boolean isAdmin;

    public User(String username, String fname, String lname, String password, Date dob, boolean isAdmin){
        this.username=username;
        this.fname=fname;
        this.lname=lname;
        this.password=password;
        this.dob=dob;
        this.isAdmin=isAdmin;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
