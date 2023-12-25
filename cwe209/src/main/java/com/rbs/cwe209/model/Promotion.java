package com.rbs.cwe209.model;

public class Promotion {
    private Long _id;
    private String name;
    private String description;
    private String image;

    public Promotion(Long _id, String name, String description, String image) {
        this._id = _id;
        this.name = name;
        this.description = description;
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
