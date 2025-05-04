package com.foody.foody_project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var fkUserId: String?,
    var fkRestaurantId: String?,
    var fkPaymentId: String?,
    var orderStatus: Boolean?
) {
    constructor(): this(null, null, null, null, null)
}
