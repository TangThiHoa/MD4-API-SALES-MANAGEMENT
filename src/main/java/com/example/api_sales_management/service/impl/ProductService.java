package com.example.api_sales_management.service.impl;

import com.example.api_sales_management.model.Product;
import com.example.api_sales_management.repository.ProductRepository;
import com.example.api_sales_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository ;

    @Override
    public Iterable<Product> findAllByNameContaining(String name) {
        return productRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Product> findAllByOrderByPrice() {
        return productRepository.findAllByOrderByPrice();
    }


    @Override
    public Iterable<Product> getTop3New() {
        return productRepository.getTop3New();
    }

    @Override
    public Iterable<Product> findAllByPriceBetween(int from, int to) {
        return productRepository.findAllByPriceBetween(from,to);
    }

    @Override
    public List<Product> findAllByPriceGreaterThan300() {
        return productRepository.findAllByPriceGreaterThan300();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);

    }
}
