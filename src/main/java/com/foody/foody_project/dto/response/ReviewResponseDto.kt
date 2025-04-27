package com.foody.foody_project.dto.response

import java.math.BigDecimal
import java.time.LocalDate

data class ReviewResponseDto(
    val reviewText: String?,
    val userFullName: String?,
    val userPhoto: String?,
    val reviewDate: LocalDate?,
    val reviewPoint: BigDecimal?
)
