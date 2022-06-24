package com.example.api_sales_management.controller;

import com.example.api_sales_management.model.Order;
import com.example.api_sales_management.model.Product;
import com.example.api_sales_management.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @GetMapping("")     //Hiển thị
    public ResponseEntity<Iterable<Order>> findAllOrder() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")     //Thêm mới
    public ResponseEntity add(@RequestBody Order order) {
        orderService.save(order);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/{id}")         //Tìm theo id
    public ResponseEntity<Order> findOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.findById(id);
        if (!order.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order.get(), HttpStatus.OK);
    }
    @PutMapping("/{id}")           //Chỉnh sửa theo id
    public ResponseEntity updateOrder(@RequestBody Order order, @PathVariable Long id) {
        Optional<Order> orderOptional = orderService.findById(id);
        if (!orderOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        order.setId(orderOptional.get().getId());
        orderService.save(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")              //Xóa theo id
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.findById(id);
        if (!orderOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderService.remove(id);
        return new ResponseEntity<>(orderOptional.get(), HttpStatus.OK);
    }


    @GetMapping("/find-all-create-at-between")
    public ResponseEntity findAllByCreateAtBetween(@RequestParam String from,@RequestParam String to) {
        return new ResponseEntity(orderService.findAllByCreateAtBetween(LocalDateTime.parse(from), LocalDateTime.parse(to)), HttpStatus.OK);
    }
}
