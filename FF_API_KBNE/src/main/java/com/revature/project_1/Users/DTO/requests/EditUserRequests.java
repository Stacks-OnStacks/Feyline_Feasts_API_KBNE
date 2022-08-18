package com.revature.project_1.Users.DTO.requests;

import com.revature.project_1.util.web.DTO.EditResourceRequest;

public class EditUserRequests extends EditResourceRequest {

    private String username = super.id;
    private String fname;
    private String lname;
    private String password;


    public EditUserRequests(){
        System.out.println("************");
        System.out.println(super.id);
        System.out.println("************");
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

    @Override
    public String toString() {
        return "EditUserRequests{" +
                "username='" + super.id + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}