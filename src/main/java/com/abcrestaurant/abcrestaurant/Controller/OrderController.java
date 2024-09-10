package com.abcrestaurant.abcrestaurant.Controller;

import com.abcrestaurant.abcrestaurant.Dto.OrderDTO;
import com.abcrestaurant.abcrestaurant.Entity.Order;
import com.abcrestaurant.abcrestaurant.Repository.OrderRepository;
import com.abcrestaurant.abcrestaurant.Service.OrderService; // Assuming you have an OrderService
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;

    public OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderService.convertToEntity(orderDTO);
        Order savedOrder = orderRepository.save(order);
        OrderDTO savedOrderDTO = orderService.convertToDTO(savedOrder);
        return ResponseEntity.ok(savedOrderDTO);
    }

    @GetMapping("/get")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = orders.stream()
                .map(orderService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(orderDTOs);
    }
}
