package com.example.practica3bd.service.impl;

import com.example.practica3bd.exception.ServiceJdbcException;
import com.example.practica3bd.model.Category;
import com.example.practica3bd.model.Product;
import com.example.practica3bd.repository.Repository;
import com.example.practica3bd.repository.impl.CategoryRepositoryImpl;
import com.example.practica3bd.repository.impl.ProductRepositoryImpl;
import com.example.practica3bd.service.ProductService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private Repository<Product> productRepository;
    private Repository<Category> categoryRepository;

    public ProductServiceImpl(Connection connection) {
        this.productRepository = new ProductRepositoryImpl(connection);
        this.categoryRepository = new CategoryRepositoryImpl(connection);
    }

    public List<Product> listProducts() {
        try {
            return productRepository.listar();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(),
                    throwables.getCause());
        }
    }

    public List<Category> listCategory() {
        try {
            return categoryRepository.list();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(),
                    throwables.getCause());
        }
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }

    public Product search(Long id) {
        return productRepository.byId(id);
    }

    public void update(Long id, Product product){
        productRepository.update(id, product);
    }

}
