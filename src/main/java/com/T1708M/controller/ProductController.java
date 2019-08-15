package com.T1708M.controller;


import com.T1708M.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;

@SessionScoped
@ManagedBean(name = "productController")
public class ProductController {
    private   String name = "";
    private   String address = "";
    private   String phoneNumber= "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private  ArrayList<Product> products
            = new ArrayList<Product>(Arrays.asList(
            new Product("Kim cuong 1", "hang gia 1 ", 3000,"brand1"),
            new Product("Kim cuong 1", "hang gia 2 ", 300,"brand2"),
            new Product("Kim cuong 3", "hang gia 3", 2000,"brand3"),
            new Product("Kim cuong 4", "hang gia 4 ", 5000,"brand4"),
            new Product("Kim cuong 5", "hang gia 5 ", 7000,"brand5")

    ));

    public  ArrayList<Product> getProducts() {
        return products;
    }

    public String index() {

        return "index?faces-redirect=true";
    }




    }


