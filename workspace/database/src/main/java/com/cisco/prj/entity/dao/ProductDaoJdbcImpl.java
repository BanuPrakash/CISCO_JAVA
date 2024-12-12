package com.cisco.prj.entity.dao;

import com.cisco.prj.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJdbcImpl implements ProductDao{

    @Override
    public void addProduct(Product product) throws PersistenceException {
     final String SQL = "INSERT INTO products (id, name, price) VALUES (0, ?, ?)";
     Connection con = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            if(e.getErrorCode() == 1062) {
                throw new PersistenceException("unable to add product, product with id " + product.getId() + " already exists", e);
            }
            throw new PersistenceException("unable to add product", e);
        } finally {
            DBUtil.closeConnection(con);
        }
    }

    @Override
    public List<Product> getProducts() throws FetchException {
        final String SQL = "SELECT id, name, price FROM  products";
        List<Product> products = new ArrayList<>();
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while(rs.next()){
//                products.add(Product.builder().
//                        id(rs.getInt("id"))
//                        .name(rs.getString("name"))
//                        .price(rs.getDouble("price"))
//                        .build());
            products.add(new Product(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new FetchException("unable to get products", e);
        } finally {
            DBUtil.closeConnection(con);
        }
        return products;
    }

    @Override
    public Product getProduct(int id) throws FetchException {
        final String SQL = "SELECT id, name, price FROM  products where id = ?";
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return Product.builder().
                        id(rs.getInt("id")).
                        name(rs.getString("name")).
                        price(rs.getDouble("price"))
                        .build();
            }
        } catch (SQLException e) {
            throw new FetchException("unable to get products", e);
        } finally {
            DBUtil.closeConnection(con);
        }
        return null;
    }
}
