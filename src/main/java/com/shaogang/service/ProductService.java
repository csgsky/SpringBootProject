package com.shaogang.service;

import com.shaogang.anno.AdminOnly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by allen on 18/1/20.
 */
@Service
public class ProductService {
    @Autowired
    AuthService mAuthService;

    @AdminOnly
    public void insert() {
        System.out.println("insert product");
    }

    @AdminOnly
    public void delete() {
        System.out.println("delete product");
    }
}
