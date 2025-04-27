package com.foody.foody_project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import lombok.Builder

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var fullName: String?,
    var email: String?,
    var password: String?,
    var phone: String?,
    @Lob
    var photo: String?,
    var isEnabled: Boolean?,
    var isAccountNonLocked: Boolean?,
    var isAccountNonExpired: Boolean?,
    var isCredentialsNonExpired: Boolean?,
    var authority: String?
) {
    constructor(): this(
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    )
}