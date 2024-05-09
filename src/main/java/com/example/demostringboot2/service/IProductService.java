package com.example.demostringboot2.service;

import com.example.demostringboot2.model.Product;

import java.util.List;

public interface IProductService extends IGenerateService<Product> {
    List<Product> findByNameContaining(String name);
    List<Product> findByCategory_Id(Long id);
    List<Product> findByPriceBetween(double price, double price2);
}
