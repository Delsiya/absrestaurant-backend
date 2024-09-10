package com.abcrestaurant.abcrestaurant.Dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private String name;
    private int quantity;
    private double price;

    // Getters and Setters
}
