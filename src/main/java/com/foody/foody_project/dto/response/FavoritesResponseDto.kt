package com.foody.foody_project.dto.response

data class FavoritesResponseDto(
    val user: UserResponseDto?,
    val receiver: FoodResponseDto?,
)
