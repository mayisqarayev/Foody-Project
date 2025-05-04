package com.foody.foody_project.dto.response

import jakarta.persistence.Lob
import java.math.BigDecimal

data class RestaurantResponseDto(
    val restaurantName: String?,
    val photo: String?,
    val restaurantRating: BigDecimal?
)
