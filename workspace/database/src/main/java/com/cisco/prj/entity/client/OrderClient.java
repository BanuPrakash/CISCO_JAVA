package com.cisco.prj.entity.client;

import com.cisco.prj.entity.Customer;
import com.cisco.prj.entity.LineItem;
import com.cisco.prj.entity.Order;
import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.dao.OrderDao;
import com.cisco.prj.entity.dao.OrderDaoJdbcImpl;
import com.cisco.prj.entity.dao.PersistenceException;

public class OrderClient {
    public static void main(String[] args) {
        Order order = new Order();
        Customer customer = Customer.builder().email("rani@cisco.com").build();

        Product p1 = Product.builder().id(2).build();

        LineItem item1 = LineItem.builder()
                .order(order)
                .product(p1)
                .qty(2)
                .amount(82341) // actual from DB should be read
                .build();

        Product p2 = Product.builder().id(1).build();
        LineItem item2 = LineItem.builder()
                .order(order)
                .product(p2)
                .qty(1)
                .amount(1235) // actual from DB should be read
                .build();

        order.getItems().add(item1);
        order.getItems().add(item2);
        order.setCustomer(customer);

        OrderDao orderDao = new OrderDaoJdbcImpl();
        order.setTotal(item1.getAmount() + item2.getAmount());
        try {
            orderDao.placeOrder(order);

            System.out.println("Order Placed!!!");
        } catch (PersistenceException e) {
           e.printStackTrace();
        }
    }
}
