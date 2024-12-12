package com.cisco.prj.entity.dao;

import com.cisco.prj.entity.Product;

import java.util.List;

public interface ProductDao {
    /**
     *
     * @param product product to be added to persistent store
     * @throws PersistenceException exception if unable to persist
     *
     * Method to add product to persistent store
     */
    void addProduct(Product product) throws PersistenceException;

    /**
     *
     * @return all products
     * @throws FetchException exception if unable to products
     *
     * method to get all products from persistent store
     */
    List<Product> getProducts() throws FetchException;
    Product getProduct(int id) throws  FetchException;
}
