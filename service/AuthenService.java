package com.longg.service;

import com.longg.db.Database;
import com.longg.dto.Customer;

public class AuthenService {

    public int login(String id, String password) {
        for (Customer c : Database.CUSTOMER_DB) {
            if (c.id.equals(id) && c.password.equals(password)) {
                return 1;
            }
        }
        return 0;
    }
}