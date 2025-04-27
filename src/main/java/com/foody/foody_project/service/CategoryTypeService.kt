package com.foody.foody_project.service

import com.foody.foody_project.exception.InvalidArgumentException
import com.foody.foody_project.model.CategoryType
import com.foody.foody_project.repository.CategoryTypeRepository
import org.springframework.stereotype.Service

@Service
class CategoryTypeService(private val repository: CategoryTypeRepository) {

    fun getCategory(id: String?): CategoryType {
        id ?: throw InvalidArgumentException("Id is null")
        return repository.findById(id).get()
    }
}