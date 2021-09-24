package com.example.mad;

public class OrdersModelClass {

    private  int OrderId;
    private String itemName, brand, customer, description, reqDate;


    public  OrdersModelClass (){

    }

    public OrdersModelClass(int orderId, String itemName, String brand, String customer, String description, String reqDate) {
        OrderId = orderId;
        this.itemName = itemName;
        this.brand = brand;
        this.customer = customer;
        this.description = description;
        this.reqDate = reqDate;
    }

    public OrdersModelClass(String itemName, String brand, String customer, String description, String reqDate) {
        this.itemName = itemName;
        this.brand = brand;
        this.customer = customer;
        this.description = description;
        this.reqDate = reqDate;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }
}

