package com.example.api_sales_management.service.impl;

import com.example.api_sales_management.model.Order;
import com.example.api_sales_management.model.OrderDetail;
import com.example.api_sales_management.repository.OrderRepository;
import com.example.api_sales_management.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Iterable<Object[]> reportByCreateTime(LocalDate from, LocalDate to) {
        return orderRepository.reportByCreateTime(from,to);
    }

    @Override
    public List<Order> findAllByCreateAtBetween(LocalDateTime from, LocalDateTime to) {
        return orderRepository.findAllByCreateAtBetween(from,to);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);

    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        orderRepository.findDetailByOrderId(id);

    }
}
