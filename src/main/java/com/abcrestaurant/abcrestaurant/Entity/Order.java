package com.abcrestaurant.abcrestaurant.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "delivery_type", nullable = false)
    private String deliveryType;
    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;
    @Column(name = "address")
    private String address;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "total_amount", nullable = false)
    private double totalAmount;
    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderItem> orderItems;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderItem {
        @Column(name = "name", nullable = false)
        private String name;
        @Column(name = "quantity", nullable = false)
        private int quantity;
        @Column(name = "price", nullable = false)
        private double price;
    }
}
