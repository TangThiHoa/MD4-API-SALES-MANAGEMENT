package com.example.api_sales_management.repository;

import com.example.api_sales_management.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    //Tìm trong khoảng thời gian
    //Tổng hóa đơn
}
