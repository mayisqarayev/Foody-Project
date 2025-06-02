package com.foody.foody_project.security

import com.foody.foody_project.service.UserService
import org.springframework.context.annotation.Lazy
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService(
    @Lazy
    private val service: UserService
): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        return service.getProfileByUsername(username)
    }
}