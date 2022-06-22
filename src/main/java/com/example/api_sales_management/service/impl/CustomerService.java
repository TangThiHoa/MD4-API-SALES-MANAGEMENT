package com.example.api_sales_management.service.impl;

import com.example.api_sales_management.model.Customer;
import com.example.api_sales_management.model.Product;
import com.example.api_sales_management.repository.CustomerRepository;
import com.example.api_sales_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAllByNameContaining(String name) {
        return customerRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Customer> findAllByOrderByAge() {
        return customerRepository.findAllByOrderByAge();
    }

    @Override
    public Iterable<Customer> findAllByAgeBetween(int from, int to) {
        return customerRepository.findAllByAgeBetween(from, to);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);

    }
}
