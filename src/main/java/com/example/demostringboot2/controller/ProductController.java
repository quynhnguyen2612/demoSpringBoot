package com.example.demostringboot2.controller;

import com.example.demostringboot2.model.Product;
import com.example.demostringboot2.service.ICategoryService;
import com.example.demostringboot2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")

public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> list = productService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody Product product) {
        productService.save(product);
        String message = "Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
        String message = "Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        productService.remove(id);
        String message = "Deleted success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@RequestParam("name") String name) {
        List<Product> list = productService.findByNameContaining(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/classes/{id}")
    public ResponseEntity<List<Product>> search(@PathVariable Long id) {
        List<Product> list = productService.findByCategory_Id(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("searchPrice")
    public ResponseEntity<List<Product>> searchPrice(@RequestParam double from, @RequestParam double to){
        List<Product> list = productService.findByPriceBetween(from, to);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}

