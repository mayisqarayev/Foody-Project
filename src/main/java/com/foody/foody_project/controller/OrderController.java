package com.foody.foody_project.controller;

import com.foody.foody_project.dto.request.AddOrderRequestDto;
import com.foody.foody_project.dto.response.OrderResponseDto;
import com.foody.foody_project.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public List<OrderResponseDto> getOrdersByUserId(@PathVariable String userId) {
        return service.getOrdersByUserId(userId);
    }
    @GetMapping("/history/{userId}")
    public List<OrderResponseDto> getOrderHistoryByUserId(@PathVariable String userId) {
        return service.getOrderHistoryByUserId(userId);
    }

    @PostMapping
    public void addOrder(AddOrderRequestDto requestDto) {
        service.addOrder(requestDto);
    }

    @PatchMapping("/{id}")
    public void completeOrder(@PathVariable String id) {
        service.completeOrder(id);
    }
}
