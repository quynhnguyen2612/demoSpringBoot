package com.example.demostringboot2.service.impl;

import com.example.demostringboot2.model.Category;
import com.example.demostringboot2.repository.CategoryRepository;
import com.example.demostringboot2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void remove(Long id) {

    }
}
