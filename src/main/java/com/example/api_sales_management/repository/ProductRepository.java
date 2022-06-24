package com.example.api_sales_management.repository;

import com.example.api_sales_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findAllByNameContaining(String name);    //Tìm kiểm theo tên

    Iterable<Product> findAllByOrderByPrice();                 //Sắp xếp theo giá tăng dần


    @Query(value = "select * from product order by id desc LIMIT 3", nativeQuery = true)
    Iterable<Product> getTop3New();                                  //Tìm 4 sản phẩm mới nhất theo id

    Iterable<Product> findAllByPriceBetween(int from, int to);  //Tìm kiểm trong khoảng giá


    //- tìm ra các product còn trong kho > 300
    @Query(value = "select * from product where price > 300", nativeQuery = true)
    List<Product> findAllByPriceGreaterThan300();

}
