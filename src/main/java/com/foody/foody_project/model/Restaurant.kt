package com.foody.foody_project.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Restaurant(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var restaurantName: String?,
    var fkAddressId: String?,
    @Lob
    var photo: String?,
    @Lob
    var banner: String?,
    var restaurantStatus: Boolean?,
    var restaurantRating: BigDecimal? = BigDecimal.ZERO
) {
    constructor(): this(
        null, null,null,
        null, null, null, null
    )
}