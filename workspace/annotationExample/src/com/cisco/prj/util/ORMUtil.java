package com.cisco.prj.util;

import com.cisco.prj.annotation.Column;
import com.cisco.prj.annotation.Table;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ORMUtil {
    // create table TBOOK (BOOK_ID NUMERIC(12), TITLE VARCHAR(255), AMT NUMERIC(12, 2))
    // generateCreateSQL(Book.class)
    // generateCreateSQL(Employee.class)
    public static String generateCreateSQL(Class<?> clazz) {
        StringBuilder builder = new StringBuilder();
        Table table = clazz.getAnnotation(Table.class);
        if( table != null) {
            builder.append("create table ");
            builder.append(table.name());
            builder.append(" (");
            Method[] methods = clazz.getDeclaredMethods();
            for(Method m: methods) {
                if(m.getName().startsWith("get")) {
                    Column column = m.getAnnotation(Column.class);
                    if(column != null) {
                        builder.append(column.name());
                        builder.append(" ");
                        builder.append(column.type());
                        builder.append(", ");
                    }
                }
            }
        }
        builder.setCharAt(builder.lastIndexOf(","), ')');
        return builder.toString();
    }

    // Book b = new Book(24, "Hibernate in Action", 1200.22);
    // insert into TBOOK values (24, 'Hibernate in Action', 1200.22)
    public static String generateInsertSQL(Object obj) {
        StringBuilder builder = new StringBuilder();
        Table table = obj.getClass().getAnnotation(Table.class);
        if( table != null) {
            builder.append("insert table ");
            builder.append(table.name());
            builder.append(" values ");
            builder.append(" (");

            Method[] methods = obj.getClass().getDeclaredMethods();
            for(Method m: methods) {
                if(m.getName().startsWith("get")) {
                    Column column = m.getAnnotation(Column.class);
                    if(column != null) {
                        try {
                            Object ret = m.invoke(obj);
                            if( ret instanceof  String) {
                                builder.append("'");
                                builder.append(ret);
                                builder.append("'");
                            } else {
                                builder.append(ret);
                            }
                            builder.append(" , ");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        builder.setCharAt(builder.lastIndexOf(","), ')');
        return builder.toString();
    }


}
