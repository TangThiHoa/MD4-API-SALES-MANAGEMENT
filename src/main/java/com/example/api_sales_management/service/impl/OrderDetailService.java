package com.example.api_sales_management.service.impl;

import com.example.api_sales_management.model.OrderDetail;
import com.example.api_sales_management.repository.OrderDetailRepository;
import com.example.api_sales_management.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;


    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public Iterable<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        orderDetailRepository.deleteById(id);

    }
}
