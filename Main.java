package com.longg;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.longg.db.Database;
import com.longg.dto.Cart;
import com.longg.dto.CartItem;
import com.longg.dto.Product;
import com.longg.service.AuthenService;
import com.longg.service.ShoppingCartService;

public class Main {

    static Cart cart;
    static Scanner scan = new Scanner(System.in);
    private static final int VIEW_CART_OPTION_ON_MENU = 0;

    private static ShoppingCartService cartService = new ShoppingCartService();
    private static AuthenService authenService = new AuthenService();

    public static void main(String[] args)  {
        selectShop(); 

        int isLoggedin;

        do {
            isLoggedin = doLogin();
        } while (isLoggedin == 0);

        while (1 == 1) {
            showMenu();

            System.out.print("Enter An Option: ");
            int option = scan.nextInt();
            scan.nextLine();

            if (option == VIEW_CART_OPTION_ON_MENU) {
                cartService.showCart(cart);
            } else {
                doAddProductToCart(option);
            }
        }
    }

    private static void selectShop() {
        System.out.println("Select a shop:");
        System.out.println("1. Shop A");
        System.out.println("2. Shop B");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(scan.nextLine());

        if (choice == 1) {
            Database.loadCustomersFromShop("shopA");
        } else {
            Database.loadCustomersFromShop("shopB"); 
        }
    }

    private static void showMenu() {
        System.out.println("0. View Cart");
        for (int i = 0; i < Database.PRODUCT_DB.size(); i++) {
            System.out.println((i + 1) + ". " + Database.PRODUCT_DB.get(i).name + " : " + Database.PRODUCT_DB.get(i).price);
        }
    }

    private static int doLogin() {
        System.out.print("Enter ID: ");
        String userID = scan.nextLine();

        System.out.print("Enter Password: ");
        String userPassword = scan.nextLine();

        int isLoggedin = authenService.login(userID, userPassword);
        if (isLoggedin == 1) {
            cart = new Cart();
            cart.items = new ArrayList<CartItem>();
        }
        return isLoggedin;
    }

    private static void doAddProductToCart(int productIndex) {
        Product selectedProduct = Database.PRODUCT_DB.get(productIndex - 1);

        System.out.print("Enter quantity : ");
        int quantity = Integer.parseInt(scan.nextLine());

        cartService.addToCart(cart, selectedProduct, quantity);

        System.out.println("Added successfully.");
    }
}




