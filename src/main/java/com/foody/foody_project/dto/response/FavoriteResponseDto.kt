package com.foody.foody_project.dto.response

data class FavoriteResponseDto(
    val user: UserResponseDto?,
    val receiver: RestaurantResponseDto?,
)
