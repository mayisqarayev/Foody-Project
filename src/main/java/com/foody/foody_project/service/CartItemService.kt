package com.foody.foody_project.service

import com.foody.foody_project.converter.CartItemConverter
import com.foody.foody_project.dto.request.AddCartItemRequestDto
import com.foody.foody_project.dto.response.CartItemResponseDto
import com.foody.foody_project.repository.CartItemRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CartItemService(
    private val repository: CartItemRepository,
    private val converter: CartItemConverter,
    private val foodService: FoodService,
    private val cartService: CartService
) {

    fun getCartItems(cartId: String): List<CartItemResponseDto> {
        return cartService.getCartItems(cartId)
    }

    fun addCartItem(requestDto: AddCartItemRequestDto) {
        repository.save(converter.toEntityFromAddCartItemRequestDto(requestDto))
    }

    fun increaseFoodQuantity(id: String) {
        repository.increaseFoodQuantity(id)
        val foodId = repository.findById(id).get().fkFoodId ?: ""
        repository.increaseCartItemPrice(id, foodService.getFoodPriceById(foodId))
    }

    fun decreaseFoodQuantity(id: String) {
        repository.decreaseFoodQuantity(id)
        val foodId = repository.findById(id).get().fkFoodId ?: ""
        repository.decreaseCartItemPrice(id, foodService.getFoodPriceById(foodId))
    }

    fun calculateTotalPrice(cartId: String): BigDecimal {
        return repository.calculateTotalPrice(cartId)
    }

    fun clearCartItemsByCartId(cartId: String) {
        repository.clearCartItemsByCartId(cartId)
    }

    fun removeCartItemById(id: String) {
        repository.removeCartItemById(id)
    }
}