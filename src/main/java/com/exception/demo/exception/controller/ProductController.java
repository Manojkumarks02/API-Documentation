package com.exception.demo.exception.controller;

import com.exception.demo.exception.entity.Product;
import com.exception.demo.exception.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/user/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }


    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateProduct(@RequestBody Product product,@PathVariable Long id){
        return productService.modifyProduct(id,product);
    }
}
