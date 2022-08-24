package com.revature.project_1.Users.DTO.requests;

import java.util.Date;

public class NewRegistrationRequest extends EditUserRequests{


    public String username=super.id;
    public String fname;
    public String lname;
    public String password;

    public Date dob;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    private boolean isAdmin;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getFname() {
        return fname;
    }

    @Override
    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String getLname() {
        return lname;
    }

    @Override
    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
