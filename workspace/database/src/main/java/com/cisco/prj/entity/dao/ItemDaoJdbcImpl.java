package com.cisco.prj.entity.dao;

import com.cisco.prj.entity.LineItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemDaoJdbcImpl implements  ItemDao{
    @Override
    public void addItem(LineItem item, Connection con) throws PersistenceException {
        final String SQL = "INSERT INTO items " +
                "(item_id, order_fk, product_fk, quantity, amount) " +
                " VALUES (0, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, item.getOrder().getOid());
            ps.setInt(2, item.getProduct().getId());
            ps.setInt(3, item.getQty());
            ps.setDouble(4, item.getAmount());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException("unable to add item", e);
        }
    }
}
