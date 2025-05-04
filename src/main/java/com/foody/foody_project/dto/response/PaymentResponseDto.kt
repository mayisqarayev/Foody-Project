package com.foody.foody_project.dto.response

import java.math.BigDecimal
import java.time.LocalDate

data class PaymentResponseDto(
    var paymentMethod: String?,
    var cardName: String?,
    var cardNumberMasked: String?,
    var cardCvvCodeMasked: String?,
    var totalPay: BigDecimal?,
    var cart: MutableList<CartItemResponseDto>?,
    var address: AddressResponseDto?
)
