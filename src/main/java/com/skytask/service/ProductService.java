package com.skytask.service;

import com.skytask.model.Product;
import com.skytask.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getList() {
        return productRepository.findAll();
    }

    public void create(Product product) {
        productRepository.insert_product(product.getName(), product.getDescription(), product.getPrice(), product.getStock());
    }
}