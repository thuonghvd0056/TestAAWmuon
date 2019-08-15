package com.T1708M.controller;


import com.T1708M.entity.Order;
import com.T1708M.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@ManagedBean(name = "orderController")
public class OrderController {

    private List<Order> orders;

    public OrderController() {
        this.orders = new ArrayList<Order>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String buy(Product product, String name) {
        int index = this.exists(product);

        if (index == -1) {
            this.orders.add(new Order(product, 1));
        } else {
            int quantity = this.orders.get(index).getQuantity() + 1;
            this.orders.get(index).setQuantity(quantity);
        }
        return "cart?faces-redirect=true";
    }


    public double total() {
        double totalAmount = 0;

        for(Order order : this.orders) {
            totalAmount += order.getProduct().getPrice() * order.getQuantity();
        }
        if (totalAmount >= 5000) {
            totalAmount = totalAmount*0.7;
        }
        return totalAmount;
    }

    private int exists(Product product) {
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getProduct().getName() == product.getName()) {
                return i;
            }
        }
        return -1;
    }
}
