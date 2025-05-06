package com.foody.foody_project.service

import com.foody.foody_project.converter.CartConverter
import com.foody.foody_project.dto.response.CartItemResponseDto
import com.foody.foody_project.model.Cart
import com.foody.foody_project.repository.CartRepository
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CartService(
    private val repository: CartRepository,
    private val converter: CartConverter,
    @Lazy private val cartItemService: CartItemService
) {
    fun createCart(userId: String): Cart {
        val cart = Cart()
        cart.fkUserId = userId
        return repository.save(cart)
    }

    fun getCartItems(id: String): MutableList<CartItemResponseDto> {
        return repository.findById(id).get().cartItem.stream()
            .filter { it.foodIsChecked == true }
            .map { converter.toCartItemResponseDtoFromEntity(it) }
            .toList()
    }

    fun changeIsPaidById(id: String) {
        repository.changeIsPaidById(id)
    }

    fun calculateTotalPrice(id: String): BigDecimal {
        return cartItemService.calculateTotalPrice(id)
    }
}