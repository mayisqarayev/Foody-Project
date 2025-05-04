package com.foody.foody_project.service

import com.foody.foody_project.repository.RestaurantCategoryRepository
import com.foody.foody_project.repository.RestaurantRepository
import org.springframework.stereotype.Service

@Service
class RestaurantCategoryService(
    private val repository: RestaurantCategoryRepository,
    private val categoryService: CategoryService
) {

    fun getRestaurantsByCategory(category: String): MutableList<String> {
        val categoryId = categoryService.getCategoryByName(category).id
        val restaurants = repository.getRestaurantsByCategoryId(categoryId)
        return restaurants
    }

}