package com.rbs.cwe209.model;

import java.util.Date;
import java.util.Hashtable;


public class Order {

    private Long _id;
    private String buyer;
    // private String<Object> products ;  ??
    private Date date;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status; // pending, accepted, denied
    // private   notified:Boolean;
    //private   _user:User;
    private int totalPrice;

    private Hashtable<String, CakeInfo> products;

    public void addProduct(String name, int amount, int price) {
        if(products.containsKey(name)){
            int current = products.get(name).amount;
            int newVal = current + amount;
            products.put(name, new CakeInfo(newVal,price));
        }
        else{
            products.put(name,  new CakeInfo(amount,price));
        }
        calculateTotalPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Order(String name) {
        products = new Hashtable<>();
        date = new Date();
        buyer = name;
        status = "pending";
    }

    public String getBuyer() {
        return buyer;
    }

    public Date getDate() {
        return date;
    }

    public Hashtable<String, CakeInfo> getProducts() {
        return products;
    }

    private void calculateTotalPrice(){
        totalPrice = 0;
        for(CakeInfo ci : products.values()){
            totalPrice+= ci.amount*ci.price;
        }
    }

    private class CakeInfo {
        public int amount;
        public int price;
        public CakeInfo(int amount, int price) {
            this.amount = amount;
            this.price = price;
        }

    }
}
