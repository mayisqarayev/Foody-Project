package com.foody.foody_project.dto.request

import java.time.LocalDate

data class AddCardRequestDto(
    val cardName: String?,
    val cardNumber: String?,
    val cardCvvCode: String?,
    val cardExpireDate: LocalDate?
)