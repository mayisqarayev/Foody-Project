package com.foody.foody_project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import lombok.Builder
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var fullName: String?,
    private var email: String?,
    private var password: String?,
    var phone: String?,
    @Lob
    var photo: String?,
    var isEnabled: Boolean?,
    var isAccountNonLocked: Boolean?,
    var isAccountNonExpired: Boolean?,
    var isCredentialsNonExpired: Boolean?,
    private var authority: String?
): UserDetails {
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

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(this.authority))
    }

    override fun getPassword(): String {
        return this.password ?: "Password is null"
    }

    override fun getUsername(): String {
        return this.email ?: "Username is null"
    }

    fun getEmail(): String? {
        return email
    }

    fun setPassword(password: String?) {
        this.password = password
    }

    fun setEmail(username: String?) {
        this.email = username
    }

    fun setAuthority(authority: String?) {
        this.authority = authority
    }
}