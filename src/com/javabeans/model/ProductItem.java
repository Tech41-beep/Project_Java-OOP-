package com.javabeans.model;

public class ProductItem {
    private Product product;
    private double quantities;

    public ProductItem(Product product, double quantities) {
        this.product = product;
        this.quantities = quantities;
    }
    
    public void setProduct(Product product) {
        if(product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        this.product = product;
    }
        public Product getProduct() {
        return product;
    }
 
    public double getQuantities() {
        return quantities;
    }
    public void setQuantities(double quantities) {
        if(quantities < 0) {
            throw new IllegalArgumentException("Quantities cannot be negative");
        }
        this.quantities = quantities;
    }
    public double getTotalPrice() {
        return product.getPrice() * quantities;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return product.getName() + "\t\t" + quantities + "\t\t" + getTotalPrice();
    }

}

