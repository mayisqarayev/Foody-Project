package com.foody.foody_project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
data class Food(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var foodName: String?,
    var foodStatus: Boolean?,
    var foodPrice: BigDecimal? = BigDecimal.ZERO,
    var foodDescription: String?,
    var foodRating: BigDecimal? = BigDecimal.ZERO,
    var fkCategoryId: String?
) {
    constructor() : this(
        null, null, null, null, null, null, null
    )
}



