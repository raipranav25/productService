package com.productservice.productservice.repository;

import com.productservice.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    List<Product> findAll();

    List<Product> findAllByTitle(String name);

    @Query(value = "select * from product", nativeQuery = true)
    List<Product> findAllByPrice_ValueGreaterThan(Double x );
}
