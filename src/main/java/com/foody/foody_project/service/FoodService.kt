package com.foody.foody_project.service

import com.foody.foody_project.converter.FoodConverter
import com.foody.foody_project.dto.request.FilterFoodRequestDto
import com.foody.foody_project.dto.response.FoodResponseDto
import com.foody.foody_project.repository.FoodRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class FoodService(
    private val repository: FoodRepository,
    private val converter: FoodConverter,
    private val categoryService: CategoryService
) {
    fun getFoodsByFilterByPrice(requestDto: FilterFoodRequestDto): List<FoodResponseDto> {
        val foodsBetweenPrice = repository.findAllFoodsBetweenPriceDesc(
            requestDto.minPrice, requestDto.maxPrice
        );

        return foodsBetweenPrice.stream()
            .filter { it.fkCategoryId == requestDto.categoryId }
            .map { converter.toFoodResponseDtoFromEntity(it) }
            .toList()
    }

    fun getFoodsByFilterByPriceAsc(requestDto: FilterFoodRequestDto): List<FoodResponseDto> {
        val foodsBetweenPrice = repository.findAllFoodsBetweenPriceAsc(
            requestDto.minPrice, requestDto.maxPrice
        );

        return foodsBetweenPrice.stream()
            .filter { it.fkCategoryId == requestDto.categoryId }
            .map { converter.toFoodResponseDtoFromEntity(it) }
            .toList()
    }

    fun getFoodsByFilterByRatingDesc(requestDto: FilterFoodRequestDto): List<FoodResponseDto> {
        val foodsBetweenPrice = repository.findAllFoodsBetweenPriceByRatingDesc(
            requestDto.minPrice, requestDto.maxPrice
        );

        return foodsBetweenPrice.stream()
            .filter { it.fkCategoryId == requestDto.categoryId }
            .map { converter.toFoodResponseDtoFromEntity(it) }
            .toList()
    }

    fun getFoodsByFilterByRatingAsc(requestDto: FilterFoodRequestDto): List<FoodResponseDto> {
        val foodsBetweenPrice = repository.findAllFoodsBetweenPriceByRatingAsc(
            requestDto.minPrice, requestDto.maxPrice
        );

        return foodsBetweenPrice.stream()
            .filter { it.fkCategoryId == requestDto.categoryId }
            .map { converter.toFoodResponseDtoFromEntity(it) }
            .toList()
    }

    fun getSearchedFoodsByName(name: String?): List<FoodResponseDto> {
         return repository.findAllFoodsByName(name).stream()
            .map { converter.toFoodResponseDtoFromEntity(it)}
            .toList()
    }

    fun getSearchedFoodsByDescription(description: String?): List<FoodResponseDto> {
        return repository.findAllFoodsByDescription(description).stream()
            .map { converter.toFoodResponseDtoFromEntity(it)}
            .toList()
    }

    fun getSearchedFoodsByCategory(categoryName: String?): List<FoodResponseDto> {
        val searchedCategory = categoryService.getCategoryByName(categoryName)

        return repository.findAll().stream()
            .filter { it.fkCategoryId == searchedCategory.id }
            .map { converter.toFoodResponseDtoFromEntity(it) }
            .toList()
    }

    fun calculateFoodRating(point: BigDecimal, id: String, countOfReview: BigDecimal) {
        val food = repository.findById(id).get()
        val foodRating = food.foodRating
        var count = countOfReview.toLong()

        if(count > 1) {
            count -= 1
            var totalPoint = count * foodRating!!.toLong()
            totalPoint += point.toLong()
            val newFoodRating = totalPoint/(count+1)
            food.foodRating = BigDecimal.valueOf(newFoodRating)
        } else {
            food.foodRating = point
        }

        repository.save(food)
    }

    fun getFoodById(id: String): FoodResponseDto {
        return converter.toFoodResponseDtoFromEntity(repository.findById(id).get())
    }

    fun getFoodPriceById(id: String): BigDecimal {
        return repository.findById(id).get().foodPrice ?: BigDecimal.ZERO
    }
}