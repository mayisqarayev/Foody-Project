package com.foody.foody_project.dto.response

import jakarta.persistence.Lob

data class UserResponseDto(
    val fullName: String?,
    val email: String?,
    val phone: String?,
    val photo: String?
)
