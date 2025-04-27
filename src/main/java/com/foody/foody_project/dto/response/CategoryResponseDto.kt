package com.foody.foody_project.dto.response

import java.math.BigDecimal

data class CategoryResponseDto(
    val categoryName: String?,
    val popularityScore: BigDecimal?,
    val categoryPhoto: String?,
    val categoryType: CategoryTypeResponseDto?
)
