package com.longg.db;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import com.longg.dto.Customer;
import com.longg.dto.Product;

public class Database {
    public static final ArrayList<Customer> CUSTOMER_DB = new ArrayList<Customer>();
    public static final ArrayList<Product> PRODUCT_DB = new ArrayList<Product>();

    public static void loadCustomersFromShop(String shopName) {
        CUSTOMER_DB.clear();

        Scanner fileScanner = new Scanner(new File("db/" + shopName + "/customer.txt"));
        fileScanner.nextLine(); 

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(",");
            String id = parts[0].trim();
            String password = parts[1].trim();
            CUSTOMER_DB.add(new Customer(id, password));
        }

        fileScanner.close();
    }

    static {
        PRODUCT_DB.add(new Product("Coffee", 5));
        PRODUCT_DB.add(new Product("Milk", 3));
    }
}
