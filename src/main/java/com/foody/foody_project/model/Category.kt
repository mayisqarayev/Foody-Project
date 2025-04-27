package com.foody.foody_project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var categoryName: String?,
    var popularityScore: BigDecimal? = BigDecimal.ZERO,
    var categoryStatus: Boolean?,
    var categoryPhoto: String?,
    var fkCategoryTypeId: String?
) {
    constructor(): this(null,null,null,null,null,null)
}
