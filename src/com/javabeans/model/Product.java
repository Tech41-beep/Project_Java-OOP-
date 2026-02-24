package com.javabeans.model;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) { this.price = price; }
    public double getPrice() { 
        return price; 
    }
    public String getName() {
         return name; 
        }

    public void printInfo() {
        System.out.println("Product: " + name + ", Price: $" + price);
    }
}