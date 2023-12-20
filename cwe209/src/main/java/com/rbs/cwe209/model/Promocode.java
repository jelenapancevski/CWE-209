package com.rbs.cwe209.model;

public class Promocode {
    private Long _id;
    private String name;
    private int percent;

    public Promocode(Long _id, String name, int percent) {
        this._id = _id;
        this.name = name;
        this.percent = percent;
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

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
