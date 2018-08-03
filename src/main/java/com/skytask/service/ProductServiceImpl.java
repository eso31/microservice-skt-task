package com.skytask.service;

import com.skytask.model.Product;
import com.skytask.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getList() {
        return productRepository.findAll();
    }

    public void create(Product product) {
        productRepository.insertProduct(product.getName(), product.getDescription(), product.getPrice(), product.getStock());
    }
}