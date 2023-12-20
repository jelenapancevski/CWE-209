package com.rbs.cwe209.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;


public class Order {

    private Long _id;
    private String buyer;
    // private String<Object> products ;  ??
    private Date date;
    private String status; // pending, accepted, denied
    // private   notified:Boolean;
    //private   _user:User;
    private int totalPrice;

    private Hashtable<String, CakeInfo> items;

    public void addItem(String name, int amount, int price) {
        if(items.containsKey(name)){
            int current = items.get(name).amount;
            int newVal = current + amount;
            items.put(name, new CakeInfo(newVal,price));
        }
        else{
            items.put(name,  new CakeInfo(amount,price));
        }
        calculateTotalPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Order(String name) {
        items = new Hashtable<>();
        date = new Date();
        buyer = name;
    }

    public String getBuyer() {
        return buyer;
    }

    public Date getDate() {
        return date;
    }

    public Hashtable<String, CakeInfo> getItems() {
        return items;
    }

    private void calculateTotalPrice(){
        totalPrice = 0;
        for(CakeInfo ci : items.values()){
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
