package com.exception.demo.exception.service;

import com.exception.demo.exception.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);


    Product getById(Long id);

    Product modifyProduct(Long id, Product product);
}
