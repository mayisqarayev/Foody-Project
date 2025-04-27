package com.foody.foody_project.dto.request

import java.math.BigDecimal

data class FilterFoodRequestDto(
    val categoryId: String?,
    val minPrice: BigDecimal? = BigDecimal.ZERO,
    val maxPrice: BigDecimal? = BigDecimal.ZERO
)
