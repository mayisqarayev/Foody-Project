package com.foody.foody_project.dto.request

data class CreateUserRequestDto(
    val fullName: String?,
    val email: String?,
    val password: String?,
    val roleId: String?
)

