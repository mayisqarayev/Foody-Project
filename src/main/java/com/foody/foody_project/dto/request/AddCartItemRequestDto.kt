package com.foody.foody_project.dto.request

import java.math.BigDecimal

data class AddCartItemRequestDto(
    val foodId: String?,
    val cartId: String?
)
