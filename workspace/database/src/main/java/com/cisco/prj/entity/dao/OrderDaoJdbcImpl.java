package com.cisco.prj.entity.dao;

import com.cisco.prj.entity.LineItem;
import com.cisco.prj.entity.Order;

import java.sql.*;
import java.util.Date;

public class OrderDaoJdbcImpl implements OrderDao{
    ItemDao itemDao = new ItemDaoJdbcImpl();
    @Override
    public void placeOrder(Order order) throws PersistenceException {
        final String SQL = "INSERT INTO orders " +
                "(oid, order_date, total, customer_fk) " +
                "VALUES (0, ?, ?, ?)";
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false); // begin transaction
            PreparedStatement ps = con.prepareStatement(SQL,
                        Statement.RETURN_GENERATED_KEYS);

            Date d = new Date(); //system date
            ps.setDate(1, new java.sql.Date(d.getTime()));
            ps.setDouble(2, order.getTotal());
            ps.setString(3, order.getCustomer().getEmail()); // FK
            ps.executeUpdate();
            int orderID = 0;
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    orderID = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
            order.setOid(orderID);
            for(LineItem item : order.getItems()) {
                itemDao.addItem(item, con);
            }
            // productDao.updateProduct(...)
            con.commit(); // close tx
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            throw new PersistenceException("unable to add order", e);
        } finally {
            DBUtil.closeConnection(con);
        }
    }
}
