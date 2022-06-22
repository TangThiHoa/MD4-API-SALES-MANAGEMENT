package com.example.api_sales_management.service;

import com.example.api_sales_management.model.Customer;
import com.example.api_sales_management.model.Product;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerService extends IService<Customer>{
    Iterable<Customer> findAllByNameContaining(String name);    //Tìm kiểm theo tên khách hàng

    Iterable<Customer> findAllByOrderByAge();                 //Sắp xếp theo tuổi  tăng dần

    Iterable<Customer> findAllByAgeBetween(int from, int to);  //Tìm kiểm trong khoảng tuổi

}
