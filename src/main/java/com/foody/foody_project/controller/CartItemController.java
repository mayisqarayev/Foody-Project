package com.foody.foody_project.controller;

import com.foody.foody_project.dto.request.AddCartItemRequestDto;
import com.foody.foody_project.dto.response.CartItemResponseDto;
import com.foody.foody_project.service.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart-item")
public class CartItemController {

    private final CartItemService service;

    public CartItemController(CartItemService service) {
        this.service = service;
    }

    @GetMapping("/{cartId}")
    public List<CartItemResponseDto> getCartItems(@PathVariable String cartId) {
        return service.getCartItems(cartId);
    }

    @PostMapping
    public void addCartItem(@RequestBody AddCartItemRequestDto requestDto) {
        service.addCartItem(requestDto);
    }

    @PatchMapping("/increase/{id}")
    public void increaseFoodQuantity(@PathVariable String id) {
        service.increaseFoodQuantity(id);
    }

    @PatchMapping("/decrease/{id}")
    public void decreaseFoodQuantity(@PathVariable String id) {
        service.decreaseFoodQuantity(id);
    }

    @DeleteMapping("/clear/{cartId}")
    public void clearCartItemsByCartId(@PathVariable String cartId) {
        service.clearCartItemsByCartId(cartId);
    }

    @DeleteMapping("/item/{id}")
    public void removeCartItemById(@PathVariable String id) {
        service.removeCartItemById(id);
    }
}
