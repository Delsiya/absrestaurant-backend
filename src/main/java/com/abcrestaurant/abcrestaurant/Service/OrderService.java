package com.abcrestaurant.abcrestaurant.Service;

import com.abcrestaurant.abcrestaurant.Dto.OrderDTO;
import com.abcrestaurant.abcrestaurant.Dto.OrderItemDTO;
import com.abcrestaurant.abcrestaurant.Entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderService {
    public OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setDeliveryType(order.getDeliveryType());
        dto.setPaymentMethod(order.getPaymentMethod());
        dto.setAddress(order.getAddress());
        dto.setPhone(order.getPhone());
        dto.setEmail(order.getEmail());
        dto.setTotalAmount(order.getTotalAmount());
        List<OrderItemDTO> itemDTOs = order.getOrderItems().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        dto.setOrderItems(itemDTOs);
        return dto;
    }

    public Order convertToEntity(OrderDTO dto) {
        Order order = new Order();
        order.setDeliveryType(dto.getDeliveryType());
        order.setPaymentMethod(dto.getPaymentMethod());
        order.setAddress(dto.getAddress());
        order.setPhone(dto.getPhone());
        order.setEmail(dto.getEmail());
        order.setTotalAmount(dto.getTotalAmount());
        List<Order.OrderItem> items = dto.getOrderItems().stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
        order.setOrderItems(items);
        return order;
    }

    private OrderItemDTO convertToDTO(Order.OrderItem item) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setName(item.getName());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPrice());
        return dto;
    }

    private Order.OrderItem convertToEntity(OrderItemDTO dto) {
        Order.OrderItem item = new Order.OrderItem();
        item.setName(dto.getName());
        item.setQuantity(dto.getQuantity());
        item.setPrice(dto.getPrice());
        return item;
    }
}
