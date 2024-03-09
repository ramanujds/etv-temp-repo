package com.upg.program;

import com.upg.program.model.Clothing;
import com.upg.program.model.Electronics;
import com.upg.program.service.ShoppingCart;

public class Main {
    public static void main(String[] args) {

        try {
            // Simulating user input for electronics and clothing creation
            Electronics laptop = new Electronics("Laptop", 101, 899.99, 5, "HP", 12);
            Clothing shirt = new Clothing("T-Shirt", 201, 19.99, 10, "Large", "Cotton");

            // Creating a shopping cart and adding items
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.addToCart(laptop);
            shoppingCart.addToCart(shirt);

            // Displaying the shopping cart contents and total price
            shoppingCart.displayCart();
            System.out.println("Total Price: $" + shoppingCart.calculateTotal());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}