package com.foody.foody_project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class CategoryType(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var categoryTypeName: String?,
    var categoryTypeStatus: Boolean?
) {
    constructor(): this( null,null, null)
}
