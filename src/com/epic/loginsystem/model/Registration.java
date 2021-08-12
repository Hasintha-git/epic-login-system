package com.epic.loginsystem.model;

public class Registration {
    private String email;
    private String userName;
    private String address;
    private String contact;
    private String password;

    public Registration() {
    }

    public Registration(String email, String userName, String address, String contact, String password) {
        this.email = email;
        this.userName = userName;
        this.address = address;
        this.contact = contact;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                ", password='" + password + '\'' +
                '}';
    }
}
