package com.cisco.prj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LineItem {
    private int itemId;

    // association; belongs to an Order
    private Order order;
    // association; LineItem references a Product
    private  Product product;
    private int qty;
    private double amount; // price * qty + GST - DISCOUNT - COUPON
}
