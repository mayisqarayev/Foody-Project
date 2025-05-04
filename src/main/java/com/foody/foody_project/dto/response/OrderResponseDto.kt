package com.foody.foody_project.dto.response

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class OrderResponseDto(
    val restaurantPhoto: String?,
    val restaurantName: String?,
    val orderStatus: Boolean?,
    val totalPay: String?,
    val totalItemCount: String,
    val orderDate: LocalDateTime
)
