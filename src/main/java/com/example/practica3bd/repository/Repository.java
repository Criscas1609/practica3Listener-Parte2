package com.example.practica3bd.repository;


import com.example.practica3bd.model.Category;
import com.example.practica3bd.model.Product;

import java.sql.SQLException;
import java.util.List;
public interface Repository <T>{
    List<T> list() throws SQLException;
    List<T> listar() throws SQLException;
    T byId(Long id);
    void save(Product product);
    void delete(Long id);
    void update(Long id, Product product);


}
