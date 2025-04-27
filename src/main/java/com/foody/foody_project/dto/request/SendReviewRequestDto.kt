package com.foody.foody_project.dto.request

import java.math.BigDecimal

data class SendReviewRequestDto(
    val reviewText: String?,
    val senderUserId: String?,
    val receiverId: String?,
    val reviewPoint: BigDecimal?
)
