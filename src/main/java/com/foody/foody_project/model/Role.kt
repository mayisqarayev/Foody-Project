package com.foody.foody_project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.PrePersist

@Entity
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var roleName: String?,
    var roleStatus: Boolean?
) {
    constructor(): this(null, null, null)
    constructor(roleName: String?): this()
    @PrePersist
    fun onCreate() {
        this.roleStatus = true
    }
}
