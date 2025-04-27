package com.foody.foody_project.dto.request

import org.hibernate.engine.jdbc.Size

data class PageRequestDto(
    val pageNumber: Int,
    val pageSize: Int
)
