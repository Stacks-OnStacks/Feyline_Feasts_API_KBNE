package com.revature.project_1.util.web.DTO;

public class LoginCreds {
    private String username;
    private String password;

    private  boolean isAdbmin;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdbmin() {
        return isAdbmin;
    }

    public void setAdbmin(boolean adbmin) {
        isAdbmin = adbmin;
    }
}