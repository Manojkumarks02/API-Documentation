package com.exception.demo.exception.service.serviceImpl;

import com.exception.demo.exception.entity.Product;
import com.exception.demo.exception.exception.ProductNotFoundException;
import com.exception.demo.exception.repository.ProductRepository;
import com.exception.demo.exception.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {

//        return productRepository.findById(id).orElseThrow(()->new NoSuchElementException("product not found"));

        Optional<Product> product1 = productRepository.findById(id);
        if (product1.isPresent()) {
            return product1.get();
        } else {
            throw new NoSuchElementException("product id not there");
        }
    }

    @Override
    public Product modifyProduct(Long id, Product product) {
        try {
            Product existingProduct = productRepository.getById(id);
            existingProduct.setName(product.getName());
            existingProduct.setEmail(product.getEmail());
            existingProduct.setPhoneNumber(product.getPhoneNumber());

            return productRepository.save(existingProduct);
        } catch (EntityNotFoundException ex) {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
    }
}
