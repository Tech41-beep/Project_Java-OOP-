package com.javabeans;

import com.javabeans.model.ClothingShop ;



public class App {
    public static void main(String[] args){
        ClothingShop shop = new ClothingShop();

        System.out.println("\n===== A) MANAGER TEST =====");
        shop.staffLogin("admin","1234");
         // Manager adds products to inventory
        shop.addProduct("Basic T-Shirt (Black, M)", 12.50);
        shop.addProduct("Slim Jeans (Blue, 32)",    29.99);
        shop.addProduct("Summer Dress (White, S)",  34.00);

        shop.viewProducts();



































    // public static void main(String[] args){

    //     System.out.println("----------------------------Order Details----------------------------");

    //     // Clothes products (sell side / inventory items)
    //     Product tshirt = new Product("Basic T-Shirt (Black, M)", 12.50);
    //     Product jeans  = new Product("Slim Jeans (Blue, 32)", 29.99);

    //     // Buyer selects items (buy side / cart items)
    //     ProductItem item1 = new ProductItem(tshirt, 2);

    //     CartService cartService = new CartService();

    //     // Update price through ProductItem (ex: discount changed / seller edits price)
    //     item1.getProduct().setPrice(10.00); // updated T-shirt price

    //     // Print product info
    //     tshirt.printInfo();
    //     jeans.printInfo();

    //     // Item details
    //     System.out.println("Item 1 quantities: " + item1.getQuantities());
    //     System.out.println("Total Price: $" + item1.getTotalPrice());

    //     // Cart total before adding (will probably be 0.0 depending on your CartService)
    //     System.out.println("Cart Total Price: $" + cartService.getTotalPrice());

    //     // Add to cart
    //     cartService.addItem(item1);

    //     System.out.println("-------------------------------------------------------------------");

    //     // Update quantities of item at index 0 to 3 (buyer changes mind)
    //     cartService.UpdateItem(0, 3);

    //     System.out.println("Cart Total Price After Update: $" + cartService.getTotalPrice());
    //     System.out.println("--------------------------------------------------------------------");
    // }
}
}