package com.foody.foody_project.dto.response

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class PaymentResponseDto(
    var paymentMethod: String?,
    var cardName: String?,
    var cardNumberMasked: String?,
    var cardCvvCodeMasked: String?,
    var totalPay: BigDecimal?,
    var paymentDate: LocalDateTime?,
    var cart: MutableList<CartItemResponseDto>?,
    var address: AddressResponseDto?
)
