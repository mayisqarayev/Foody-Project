package com.foody.foody_project.dto.request

data class UpdateUserRequestDto(
    val id: String?,
    val fullName: String?,
    val email: String?,
    val phone: String?,
    val photo: String?
)
