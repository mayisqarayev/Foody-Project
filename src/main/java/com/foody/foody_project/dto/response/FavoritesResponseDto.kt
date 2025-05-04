package com.foody.foody_project.dto.response

data class FavoritesResponseDto(
    val userId: UserResponseDto?,
    val receiverId: FoodResponseDto?,
)
