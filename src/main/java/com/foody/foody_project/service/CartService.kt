package com.foody.foody_project.service

import com.foody.foody_project.converter.CartConverter
import com.foody.foody_project.dto.response.CartItemResponseDto
import com.foody.foody_project.model.Cart
import com.foody.foody_project.model.CartItem
import com.foody.foody_project.repository.CartRepository
import org.springframework.stereotype.Service

@Service
class CartService(
    private val repository: CartRepository,
    private val converter: CartConverter
) {
    fun createCart(): Cart {
        return repository.save(Cart())
    }

    fun getCartItems(id: String): MutableList<CartItemResponseDto> {
        return repository.findById(id).get().cartItem.stream()
            .map { converter.toCartItemResponseDtoFromEntity(it) }
            .toList()
    }

    fun submitCart(id: String) {

    }
}