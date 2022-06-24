package com.example.api_sales_management.controller;

import com.example.api_sales_management.model.Order;
import com.example.api_sales_management.model.OrderDetail;
import com.example.api_sales_management.model.Product;
import com.example.api_sales_management.service.IOrderDetailService;
import com.example.api_sales_management.service.IOrderService;
import com.example.api_sales_management.service.IProductService;
import com.example.api_sales_management.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/orderDetails")
public class OrderDetailController {
    @Autowired
    IOrderService orderService;
    @Autowired
    IProductService productService;
    @Autowired
    IOrderDetailService orderDetailService;

    @GetMapping("")     //Hiển thị
    public ResponseEntity<Iterable<OrderDetail>> findAllOrderDetail() {
        return new ResponseEntity<>(orderDetailService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody OrderDetail orderDetail) {
        Product product = productService.findById(orderDetail.getProduct().getId()).get();
        Order order = orderService.findById(orderDetail.getOrder().getId()).get();
        product.setQuantity(product.getQuantity() - orderDetail.getQuantity());
        productService.save(product);
        order.setTotalPrice(order.getTotalPrice() + product.getQuantity() * product.getPrice());
        orderService.save(order);
        orderDetailService.save(orderDetail);
        return new ResponseEntity(HttpStatus.CREATED);

    }
}
