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

}
