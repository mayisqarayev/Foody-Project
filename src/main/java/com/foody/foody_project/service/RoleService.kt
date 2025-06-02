package com.foody.foody_project.service

import com.foody.foody_project.dto.request.CreateRoleRequestDto
import com.foody.foody_project.repository.RoleRepository
import org.springframework.stereotype.Service
import javax.management.relation.Role

@Service
class RoleService(
    private val repository: RoleRepository
) {
    fun createRole(requestDto: CreateRoleRequestDto?) {
        repository.save(com.foody.foody_project.model.Role(
            roleName = requestDto?.roleName
        ))
    }

    fun getRole(id: String?): String {
        return repository.findById(id).get().roleName ?: "RoleNameNotSetted"
    }


}