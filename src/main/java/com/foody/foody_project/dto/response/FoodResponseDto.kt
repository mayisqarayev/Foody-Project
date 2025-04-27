package com.foody.foody_project.dto.response

import java.math.BigDecimal

data class FoodResponseDto(
    val foodName: String?,
    val foodPrice: BigDecimal?,
    val foodDescription: String?,
    val foodRating: BigDecimal? = BigDecimal.ZERO
)
