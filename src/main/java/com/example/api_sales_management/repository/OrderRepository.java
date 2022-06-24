package com.example.api_sales_management.repository;

import com.example.api_sales_management.model.Order;
import com.example.api_sales_management.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    //Tổng hóa đơn
    @Query(value = "from OrderDetail where order.id = :id")
    Iterable<OrderDetail> findDetailByOrderId(@Param("id") Long id);
//     - tìm các order trong 1 khoảng thời gian
    List<Order> findAllByCreateAtBetween(LocalDateTime from, LocalDateTime to);

    @Query(value = "select p.id, p.name, sum(od.quantity)\n" +
            "from product p\n" +
            "join order_detail od on p.id = od.product_id\n" +
            "join orders o on o.id = od.order_id\n" +
            "where o.create_at between :dateFrom and :dateTo\n" +
            "group by p.id;", nativeQuery = true)
    Iterable<Object[]> reportByCreateTime(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo);
}
