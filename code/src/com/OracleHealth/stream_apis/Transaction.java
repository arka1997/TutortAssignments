package com.OracleHealth.stream_apis;

public class Transaction{

    int quantity;
    double price;
    String products;

    public Transaction(double price, int quantity, String products) {
        this.quantity = quantity;
        this.price = price;
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
}
