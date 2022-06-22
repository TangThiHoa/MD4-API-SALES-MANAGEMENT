package com.example.api_sales_management.repository;

import com.example.api_sales_management.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail , Long> {
//Tổng toàn bộ hóa
}
