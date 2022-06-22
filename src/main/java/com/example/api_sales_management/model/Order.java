package com.example.api_sales_management.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")     //đổi tên
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createAt;
    private double totalPrice;

    @ManyToOne
    private Customer customer;

    public Order() {
    }

    public Order(Long id, LocalDateTime createAt, double totalPrice, Customer customer) {
        this.id = id;
        this.createAt = createAt;
        this.totalPrice = totalPrice;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

