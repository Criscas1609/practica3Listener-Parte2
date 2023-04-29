package com.example.practica3bd.repository.impl;



import com.example.practica3bd.ConexionBD;
import com.example.practica3bd.model.Category;
import com.example.practica3bd.model.Product;
import com.example.practica3bd.repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.practica3bd.ConexionBD.getConnection;

public class


ProductRepositoryImpl implements Repository<Product> {

    private Connection conn;


    public ProductRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    public List<Product> listar() throws SQLException {
        List<Product> productList = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT p.*,c.nombre as categoria_nombre from products as p" +
                     " inner join category as c ON (p.categoria_id=c.id)" +
                     " order by p.id ASC")) {
            while (rs.next()) {
            Product p = createProduct(rs);
            productList.add(p);
        }
    }
        return productList;
    }



    private Product createProduct(ResultSet resultSet) throws
            SQLException {
        Product producto = new Product();
        producto.setId(resultSet.getLong("id"));

        producto.setName(resultSet.getString("nombre"));
        producto.setPrice(resultSet.getDouble("precio"));
        producto.setRegisterDate(resultSet.getDate("fecha_registro").toLocalDate());
        Category categoria = new Category();
        categoria.setId(resultSet.getLong("categoria_id"));
        categoria.setName(resultSet.getString("categoria_nombre"));
        producto.setCategory(categoria);
        return producto;
    }

    public List<Product> list() throws SQLException {
        List<Product> productList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT p.*,c.nombre as categoria_nombre from products as p inner join category as c ON (p.categoria_id=c.id)")) {
            while (resultSet.next()) {
                Product producto = createProduct(resultSet);
                productList.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public Product byId(Long id) {
        Product producto = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT p.*,c.nombre as categoria_nombre from products as p inner join category as c ON (p.categoria_id=c.id) WHERE p.id=?")) {
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                producto = createProduct(resultSet);
            }else {
                System.out.println("No existe ese id");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void save(Product product) {
        try (PreparedStatement preparedStatement=getConnection().prepareStatement("INSERT INTO products(nombre,precio,fecha_registro,categoria_id) VALUES (?,?,?,?)")){
            preparedStatement.setString(1,product.getName());
            preparedStatement.setLong(2,product.getPrice().longValue());
            preparedStatement.setDate(3,Date.valueOf(product.getRegisterDate()));
            preparedStatement.setLong(4,product.getCategory().getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long valueId) {
        System.out.printf(String.valueOf(valueId));
        try {
            PreparedStatement preparedStatement = getConnection()
                    .prepareStatement("DELETE FROM products WHERE id ='"+valueId+"'");
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Long id, Product product) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("UPDATE products SET nombre=? ,precio=?,fecha_registro=? where id='"+id+"'")) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setLong(2, product.getPrice().longValue());
            preparedStatement.setDate(3, Date.valueOf(product.getRegisterDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }




}
