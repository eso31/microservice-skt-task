package com.skytask.repository;

import com.skytask.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Procedure
    int insertProduct(String name, String description, Double price, Integer stock);
}
