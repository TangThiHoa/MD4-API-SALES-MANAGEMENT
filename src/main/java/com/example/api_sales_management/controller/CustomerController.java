package com.example.api_sales_management.controller;

import com.example.api_sales_management.model.Customer;
import com.example.api_sales_management.model.Product;
import com.example.api_sales_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("")     //Hiển thị
    public ResponseEntity<Iterable<Customer>> findAllCustomer() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")     //Thêm mới
    public ResponseEntity add(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/{id}")         //Tìm theo id
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }
    @PutMapping("/{id}")           //Chỉnh sửa theo id
    public ResponseEntity updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")              //Xóa theo id
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }
    @GetMapping("/orderByAge")            //sắp xếp theo tuổi
    public ResponseEntity<Iterable<Customer>> findAllByOrderByAge() {
        Iterable<Customer> customers = customerService.findAllByOrderByAge();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/searchName")              //Tìm theo tên
    public ResponseEntity<Iterable<Customer>> findAllByNameContainingCustomer(@RequestParam String name) {
        Iterable<Customer> customers = customerService.findAllByNameContaining(name);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/ageBetween")               //Tìm trong khoảng tuổi ???
    public ResponseEntity<Iterable<Customer>> findAllByAgeBetween(@RequestParam int from, @RequestParam int to) {
        return new ResponseEntity<>(customerService.findAllByAgeBetween(from, to), HttpStatus.OK);
    }
}
