package com.foody.foody_project.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class CartItem(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var quantityOfFoods: BigDecimal? = BigDecimal.ZERO,
    var fkFoodId: String?,
    var price: BigDecimal?,
    var foodIsChecked: Boolean?,
    var fkCartId: String?
) {
    constructor(): this(null, null, null, null, null, null)
}
