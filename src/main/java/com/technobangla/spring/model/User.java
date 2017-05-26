package com.technobangla.spring.model;

/**
 * Created by Ayakuth Pathan on 24-May-17.
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private boolean active;
    private int employeeId;

    public User() {
    }

    public User(String userId, String password, boolean active, int employeeId) {
        this.userName = userId;
        this.password = password;
        this.active = active;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userId) {
        this.userName = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
