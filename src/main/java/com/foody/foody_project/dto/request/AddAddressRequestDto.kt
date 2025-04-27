package com.foody.foody_project.dto.request

data class AddAddressRequestDto(
    val addressName: String?,
    val streetName: String?,
    val cityName: String?,
    val stateName: String?,
    val userId: String?
)