package com.example.demostringboot2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;
    private double price;

    @ManyToOne
    private Category category;

}
