package com.cisco.prj.entity.dao;

import com.cisco.prj.entity.LineItem;

import java.sql.Connection;

public interface ItemDao {
    void addItem(LineItem item, Connection con) throws PersistenceException;
}
