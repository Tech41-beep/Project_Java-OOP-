package com.javabeans;
import com.javabeans.model.Product;
import com.javabeans.model.ProductItem;

public class App {
    public static void main(String[] args){
        
        Product latte = new Product("Latte", 3.5);
        Product americano = new Product("Americano", 2.5);
        ProductItem item1 = new ProductItem(latte, 2);

        item1.getProduct().setPrice(4.0); // Update price of latte through ProductItem


        latte.printInfo();
        americano.printInfo();
        System.out.println("Item 1 quantities: " + item1.getQuantities());
                System.out.println("Total Price: $" + item1.getTotalPrice());
  
    }
    }

