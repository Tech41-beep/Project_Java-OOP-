package com.javabeans.model;

public class Product {
    public String name;
    private double price;

    //this is Contructor

    public Product(String name, double price){
       this.name = name;
       this.price = price;

    }
     
    //setter and getter 

    public String getName() {
        return name;
    }

    public void setName(String name) {


            if(name.isBlank()){
        throw new IllegalArgumentException("name can not be empty bro");
    }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
            if(price < 0.0){
        throw new IllegalArgumentException("Price cannot be negative");
    }
        this.price = price;
    }

        // toString
    @Override
    public String toString() {
        return name + "\t\t" + price;
    }

    // Print info
    public void printInfo() {
        System.out.println(this.toString());
    }
}
