package com.javabeans.model;

public class ProductItem {
    private Product product;
    private double Quantities;

    public ProductItem(Product product, double quantities) {
        this.product = product;
        this.Quantities = quantities;
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
        return Quantities;
    }
    public void setQuantities(double quantities) {
        if(quantities < 0) {
            throw new IllegalArgumentException("Quantities cannot be negative");
        }
        this.Quantities = quantities;
    }
    public double getTotalPrice() {
        return product.getPrice() * Quantities;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return product.getName() + "\t\t" + Quantities + "\t\t" + getTotalPrice();
    }

}

