package com.foody.foody_project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class RestaurantFood(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var fkRestaurantId: String?,
    var fkFoodId: String?,
    var relationStatus: Boolean?
) {
    constructor(): this(null, null ,null , null)
}