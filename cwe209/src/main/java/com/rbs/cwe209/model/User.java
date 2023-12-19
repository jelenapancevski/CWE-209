package com.rbs.cwe209.model;

public class User {
    private Long _id;
    private String username;
    private String password;
    private String usertype;
    private String firstname;
    private String lastname;
    private String address;

    public User(Long _id, String username, String password, String usertype, String firstname, String lastname, String address) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

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

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
