package com.cisco.prj.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private int id;
    private  String name;
    private double price;
}
