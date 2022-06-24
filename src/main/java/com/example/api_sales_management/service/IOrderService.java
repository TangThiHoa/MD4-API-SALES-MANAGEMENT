package com.example.api_sales_management.service;

import com.example.api_sales_management.model.Order;
import com.example.api_sales_management.model.OrderDetail;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService extends IService<Order>{
    Iterable<Object[]> reportByCreateTime(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo);
    List<Order> findAllByCreateAtBetween(LocalDateTime from, LocalDateTime to);
}
