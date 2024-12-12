package com.cisco.prj.entity.client;

import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.dao.PersistenceException;
import com.cisco.prj.entity.dao.ProductDao;
import com.cisco.prj.entity.dao.ProductDaoJdbcImpl;

public class ProductAddClient {
    public static void main(String[] args) {
        Product p = Product.builder()
                .name("Wacom")
                .price(9400.00)
                .build();
        ProductDao productDao = new ProductDaoJdbcImpl();
        try {
            productDao.addProduct(p);
            System.out.println("Product added Successfully!!!");
        } catch (PersistenceException e) {
            System.out.println(e.getMessage()); // production
            e.printStackTrace(); // development stage
        }
    }
}
