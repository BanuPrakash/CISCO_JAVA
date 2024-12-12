package com.cisco.prj.entity.dao;

import com.cisco.prj.entity.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoJdbcImpl implements ProductDao{

    @Override
    public void addProduct(Product product) throws PersistenceException {
     final String SQL = "INSERT INTO products (id, name, price) VALUES (0, ?, ?)";
     Connection con = null;
        try {
            con = DBUtil.getConnection();
            //
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

        return null;
    }

    @Override
    public Product getProduct(int id) throws FetchException {
        return null;
    }
}
