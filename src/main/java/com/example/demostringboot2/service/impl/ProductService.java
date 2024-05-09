package com.example.demostringboot2.service.impl;

import com.example.demostringboot2.model.Product;
import com.example.demostringboot2.repository.ProductRepository;
import com.example.demostringboot2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.get();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByNameContaining(String name) {
        return productRepository.findByNameContaining(name);
    }

    @Override
    public List<Product> findByCategory_Id(Long id) {
        return productRepository.findByCategory_Id(id);
    }

    @Override
    public List<Product> findByPriceBetween(double from, double to) {
        List<Product> list = productRepository.findByPriceBetween(from, to);
        return list;
    }

}
