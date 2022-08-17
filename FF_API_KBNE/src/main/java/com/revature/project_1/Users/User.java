package com.revature.project_1.Users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity(name = "users")
@Table(name = "users")
public class User {


    @Id
    public String username;
    @Column(name = "fname")
    public String fname;
    @Column(name = "lname")
    public String lname;
    @Column(name = "password")
    public String password;
    @Column(name = "dob")
    public Date dob;
    @Column(name = "is_admin")
    private boolean isAdmin;

    public User(String username, String fname, String lname, String password, Date dob, boolean isAdmin){
        this.username=username;
        this.fname=fname;
        this.lname=lname;
        this.password=password;
        this.dob=dob;
        this.isAdmin=isAdmin;
    }

    public User(){}



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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
