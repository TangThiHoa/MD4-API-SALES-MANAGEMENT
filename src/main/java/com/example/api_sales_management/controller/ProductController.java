package com.example.api_sales_management.controller;

import com.example.api_sales_management.model.Product;
import com.example.api_sales_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")     //Hiển thị
    public ResponseEntity<Iterable<Product>> findAllProduct() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")     //Thêm mới
    public ResponseEntity add(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/{id}")         //Tìm theo id
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }
    @PutMapping("/{id}")           //Chỉnh sửa theo id
    public ResponseEntity updateProduct(@RequestBody Product product, @PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setId(productOptional.get().getId());
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")              //Xóa theo id
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }
    @GetMapping("/orderByPrice")            //sắp xếp theo giá
    public ResponseEntity<Iterable<Product>> findAllByOrderByPrice() {
        Iterable<Product> products = productService.findAllByOrderByPrice();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/top3New")                 //Tìm 4 sản phẩm mới nhất
    public ResponseEntity<Iterable<Product>>getTop3New(){
        Iterable<Product> products = productService.getTop3New();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/priceBetween")               //Tìm trong khoảng giá ???
    public ResponseEntity<Iterable<Product>> findAllByPriceBetween(@RequestParam int from, @RequestParam int to) {
        return new ResponseEntity<>(productService.findAllByPriceBetween(from, to), HttpStatus.OK);
    }
    @GetMapping("/searchName")              //Tìm theo tên
    public ResponseEntity<Iterable<Product>> findAllByNameContainingProduct(@RequestParam String name) {
        Iterable<Product> products = productService.findAllByNameContaining(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
