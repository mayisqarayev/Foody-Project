package com.foody.foody_project.dto.response

import java.math.BigDecimal

data class CartItemResponseDto(
    var quantityOfFoods: BigDecimal?,
    var food: FoodResponseDto?,
    var price: BigDecimal?,
    var foodIsChecked: Boolean?,
)
