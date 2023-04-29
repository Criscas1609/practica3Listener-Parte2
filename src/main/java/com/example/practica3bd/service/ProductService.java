package com.example.practica3bd.service;

import com.example.practica3bd.model.Category;
import com.example.practica3bd.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProducts();
    List<Category> listCategory();
    void save(Product product);
    void delete(Long id);
    Product search(Long id);
    void update(Long id, Product product);
}
