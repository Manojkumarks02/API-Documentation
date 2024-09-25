package com.exception.demo.exception.repository;

import com.exception.demo.exception.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
