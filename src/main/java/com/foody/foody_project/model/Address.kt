package com.foody.foody_project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var addressName: String?,
    var streetName: String?,
    var cityName: String?,
    var stateName: String?,
    var addressStatus: Boolean?,
    var fkUserId: String?
) {
    constructor(): this(null, null, null, null, null,null, null)
}
