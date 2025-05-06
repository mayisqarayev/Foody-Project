package com.foody.foody_project.controller;

import com.foody.foody_project.dto.response.CartItemResponseDto;
import com.foody.foody_project.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public void createCart(@PathVariable String userId){
        service.createCart(userId);
    }

    @PatchMapping("/{id}")
    public void changeIsPaidById(@PathVariable String id) {
        service.changeIsPaidById(id);
    }

    @GetMapping("/{id}")
    public BigDecimal calculateTotalPrice(@PathVariable String id) {
        return service.calculateTotalPrice(id);
    }
}
