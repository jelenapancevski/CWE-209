package com.rbs.cwe209.model;

import java.util.List;

public class Location {
    private Long _id;

    private String name;
    private String phone;
    private String address;
    private String workinghours;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    private String src;
    private boolean open;

    public Location(Long _id, String name, String phone, String address, String workinghours,String src, boolean open) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.workinghours = workinghours;
        this.src = src;
        this.open = open;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(String workinghours) {
        this.workinghours = workinghours;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
