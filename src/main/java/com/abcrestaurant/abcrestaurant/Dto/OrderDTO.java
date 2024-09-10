package com.abcrestaurant.abcrestaurant.Dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private String deliveryType;
    private String paymentMethod;
    private String address;
    private String phone;
    private String email;
    private double totalAmount;
    private List<OrderItemDTO> orderItems;

    // Getters and Setters
}
