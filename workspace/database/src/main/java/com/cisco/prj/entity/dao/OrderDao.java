package com.cisco.prj.entity.dao;

import com.cisco.prj.entity.Order;

public interface OrderDao {
    void placeOrder(Order order) throws PersistenceException;
}
