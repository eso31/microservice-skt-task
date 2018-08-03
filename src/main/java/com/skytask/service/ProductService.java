package com.skytask.service;

import com.skytask.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getList();

    void create(Product product);
}
