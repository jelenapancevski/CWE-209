package com.rbs.cwe209.model;

import java.sql.Array;
import java.util.List;


public class Product {


    private Long _id;

    private List<String> ingredients;

    private String name;
    private String description;
    private String producttype;
    private int price;
    private String image;


    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    private String secret;


    public void set_id(Long _id) {
        this._id = _id;
    }
// getters and setters

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Long get_id() {
        return _id;
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

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product(Long id, List<String> ingredients, String name, String description, String producttype, int price, String image,String secret) {
        this._id = id;
        this.ingredients = ingredients;
        this.name = name;
        this.description = description;
        this.producttype = producttype;
        this.price = price;
        this.image = image;
        this.secret = secret;
    }
}
