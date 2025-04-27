package com.foody.foody_project.dto.response

data class PageResponseDto(
    val totalPages: Int?,
    val totalElements: Long?,
    val hasNext: Boolean?,
    val content: List<ReviewResponseDto>?
)
