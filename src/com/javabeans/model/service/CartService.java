package com.javabeans.model.service;

import java.util.ArrayList;
import com.javabeans.model.ProductItem;

public class CartService {

    private ArrayList<ProductItem> cartItems;

    // Constructor (VERY IMPORTANT)
    public CartService() {
        cartItems = new ArrayList<>();
    }

    public void addItem(ProductItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        cartItems.add(item);
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (ProductItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }
    public void removebyIndex(int index) {
        if (index < 0 || index >= cartItems.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        cartItems.remove(index);
    }
// Update item at specific index
    public void UpdateItem(int index, int quantities) {
         if (index < 0 || index >= cartItems.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index < 0 || index >= cartItems.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        cartItems.get(index).setQuantities(quantities);
    }
    
    public void printCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        for (ProductItem item : cartItems) {
            System.out.println(item);
        }
    }
}
