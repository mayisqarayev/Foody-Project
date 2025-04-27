package com.foody.foody_project.dto.request

data class UpdateAddressRequestDto(
    val id: String?,
    val addressName: String?,
    val streetName: String?,
    val cityName: String?,
    val stateName: String?
)
