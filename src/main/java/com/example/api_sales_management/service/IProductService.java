package com.example.api_sales_management.service;

import com.example.api_sales_management.model.Product;
import org.springframework.data.jpa.repository.Query;

public interface IProductService extends IService<Product> {
    Iterable<Product> findAllByNameContaining(String name);    //Tìm kiểm theo tên

    Iterable<Product> findAllByOrderByPrice();                 //Sắp xếp theo giá tăng dần


    @Query(value = "select * from product order by id desc LIMIT 3", nativeQuery = true)
    Iterable<Product> getTop3New();                               //Tìm 4 sản phẩm mới nhất theo id

    Iterable<Product> findAllByPriceBetween(int from, int to);
}
