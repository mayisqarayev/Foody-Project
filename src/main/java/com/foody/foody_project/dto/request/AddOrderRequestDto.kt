package com.foody.foody_project.dto.request

data class AddOrderRequestDto(
    val userId: String?,
    val restaurantId: String?,
    val paymentId: String?,
)
