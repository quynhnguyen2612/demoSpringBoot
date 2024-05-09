package com.example.demostringboot2.repository;

import com.example.demostringboot2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);
    List<Product> findByCategory_Id(Long id);
    List<Product> findByPriceBetween(double price, double price2);
}
