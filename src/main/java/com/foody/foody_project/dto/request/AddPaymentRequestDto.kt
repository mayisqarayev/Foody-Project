package com.foody.foody_project.dto.request

import com.foody.foody_project.model.PaymentMethod

data class AddPaymentRequestDto(
    val paymentMethod: PaymentMethod,
    val card: AddCardRequestDto?,
    val cartId: String?,
    val addressId: String?,
)
