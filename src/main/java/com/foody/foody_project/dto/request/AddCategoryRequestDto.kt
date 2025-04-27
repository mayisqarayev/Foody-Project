package com.foody.foody_project.dto.request

data class AddCategoryRequestDto(
    val categoryName: String?,
    val categoryPhoto: String?,
    val fkCategoryTypeId: String?
)
