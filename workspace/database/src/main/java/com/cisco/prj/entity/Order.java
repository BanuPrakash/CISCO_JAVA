package com.cisco.prj.entity;

import lombok.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Order {
    private int oid;
    private Date orderDate;
    private double total;

    // association; order is by
    private Customer customer;

    // association; order has many items
    Set<LineItem> items = new LinkedHashSet<>();
}
