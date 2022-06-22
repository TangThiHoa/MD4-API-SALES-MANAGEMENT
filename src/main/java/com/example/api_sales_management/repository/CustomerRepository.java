package com.example.api_sales_management.repository;

import com.example.api_sales_management.model.Customer;
import com.example.api_sales_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Iterable<Customer> findAllByNameContaining(String name);    //Tìm kiểm theo tên khách hàng

    Iterable<Customer> findAllByOrderByAge();                 //Sắp xếp theo tuổi  tăng dần

    Iterable<Customer> findAllByAgeBetween(int from, int to);  //Tìm kiểm trong khoảng tuổi

                                //Tìm 3 khách mới nhất theo id

}
