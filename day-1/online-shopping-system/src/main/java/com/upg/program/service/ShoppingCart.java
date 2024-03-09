package com.upg.program.service;

import com.upg.program.model.Product;

public class ShoppingCart {

    private Product[] cartItems= new Product[10];

    public void addToCart(Product product) {
        // Add product to the cart
    }


    public void displayCart() {
        for (Product item : cartItems) {
            item.displayDetails();
            System.out.println("------------");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : cartItems) {
            total += item.price;
        }
        return total;
    }




}
