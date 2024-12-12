package com.cisco.prj.entity.client;

import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.dao.FetchException;
import com.cisco.prj.entity.dao.ProductDao;
import com.cisco.prj.entity.dao.ProductDaoJdbcImpl;

import java.util.List;

public class ProductFetchClient {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoJdbcImpl();

        try {
            List<Product> products = productDao.getProducts();
            for(Product p : products) {
                System.out.println(p);
            }
        } catch (FetchException e) {
            e.printStackTrace();
        }

    }
}
