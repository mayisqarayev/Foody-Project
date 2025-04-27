package com.foody.foody_project.service

import com.foody.foody_project.converter.CategoryConverter
import com.foody.foody_project.dto.request.AddCategoryRequestDto
import com.foody.foody_project.dto.response.CategoryResponseDto
import com.foody.foody_project.exception.InvalidArgumentException
import com.foody.foody_project.repository.CategoryRepository
import jdk.jfr.Category
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val repository: CategoryRepository,
    private val converter: CategoryConverter
) {

    fun getCategories(): List<CategoryResponseDto> {
        return repository.findAll().stream()
            .map { converter.toCategoryResponseDtoFromEntity(it) }
            .toList()
    }

    fun addCategory(requestDto: AddCategoryRequestDto?) {
        requestDto ?: throw InvalidArgumentException("Request is null")
        repository.save(converter.toEntityFromAddCategoryRequestDto(requestDto))
    }

    fun getCategoryByName(name: String?): com.foody.foody_project.model.Category {
        return repository.findCategoryByCategoryName(name)
            .get()
    }
}