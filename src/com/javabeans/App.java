package com.javabeans;
import com.javabeans.model.Product;
import com.javabeans.model.ProductItem;
import com.javabeans.model.service.CartService;



public class App {
    
    public static void main(String[] args){
     
        System.out.println("----------------------------Order Details----------------------------");
        Product latte = new Product("Latte", 3.5);
        Product americano = new Product("Americano", 2.5);
        ProductItem item1 = new ProductItem(latte, 2);
        CartService cartService = new CartService();


        item1.getProduct().setPrice(4.0); // Update price of latte through ProductItem

        latte.printInfo();
        americano.printInfo();
        System.out.println("Item 1 quantities: " + item1.getQuantities());
         System.out.println("Total Price: $" + item1.getTotalPrice());
         System.out.println("Cart Total Price: $" + cartService.getTotalPrice());
        cartService.addItem(item1);
         System.out.println("-------------------------------------------------------------------");
        cartService.UpdateItem(0, 3); // Update quantities of item at index 0 to 3
        System.out.println("Cart Total Price After Update: $" + cartService.getTotalPrice());
          System.out.println("--------------------------------------------------------------------");
  
    }
    }

