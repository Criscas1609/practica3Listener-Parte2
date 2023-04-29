package com.example.practica3bd.repository.impl;

import com.example.practica3bd.model.Category;
import com.example.practica3bd.model.Product;
import com.example.practica3bd.repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements Repository<Category> {

    private Connection conn;

    public CategoryRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Category> list() throws SQLException {
        List<Category> categories = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM category")) {
            while (rs.next()) {
                Category p = createCategory(rs);
                categories.add(p);
            }
        }
        return categories;
    }

    @Override
    public List<Category> listar() throws SQLException {
        return null;
    }

    @Override
    public Category byId(Long id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, Product product) {

    }


    private Category createCategory(ResultSet resultSet) throws
            SQLException {
        Category category = new Category();
        category.setId(resultSet.getLong("id"));
        category.setName(resultSet.getString("nombre"));

        return category;
    }

    }
