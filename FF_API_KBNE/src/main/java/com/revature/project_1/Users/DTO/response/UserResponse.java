package com.revature.project_1.Users.DTO.response;

import com.revature.project_1.Users.User;

import java.util.Date;

public class UserResponse {
    private String username;
    private String fname;
    private String lname;
    private String password;
    private Date dob;
    private boolean isAdmin;

    public UserResponse(){}

    public UserResponse(User user){
        this.username= user.username;
        this.fname= user.fname;
        this.lname=user.lname;
        this.password=user.password;
        this.dob=user.dob;
        this.isAdmin=user.isAdmin();
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "username='" + username + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", password='" + password + '\'' +
                ", dob=" + dob +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
