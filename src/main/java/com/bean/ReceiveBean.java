package com.bean;

public class ReceiveBean {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserBeans{" +
                "username='" + username + '\'' +
                '}';
    }
}
