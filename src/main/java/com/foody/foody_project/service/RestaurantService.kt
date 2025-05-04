package com.foody.foody_project.service

import com.foody.foody_project.converter.RestaurantConverter
import com.foody.foody_project.dto.response.RestaurantResponseDto
import com.foody.foody_project.repository.RestaurantRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import kotlin.streams.toList

@Service
class RestaurantService(
    private val repository: RestaurantRepository,
    private val converter: RestaurantConverter,
    private val restaurantService: RestaurantCategoryService,
    private val addressService: AddressService
) {
    fun getRestaurantByFilter(category: String): List<RestaurantResponseDto> {
        val restaurants = restaurantService.getRestaurantsByCategory(category)
        val findAll = repository.findAll()

        return findAll.stream()
            .filter { it.id in restaurants }
            .map { converter.toRestaurantResponseDtoFromEntity(it) }
            .toList()
    }

    fun getRestaurantByName(name: String): List<RestaurantResponseDto> {
        return repository.findAll().stream()
            .filter { it.restaurantName == name }
            .map { converter.toRestaurantResponseDtoFromEntity(it) }
            .toList()
    }

    fun getRestaurantByLocation(location: String): List<RestaurantResponseDto> {
        val addressId = addressService.getAddressIdByStreetName(location)
        return repository.findAll().stream()
            .filter { it.fkAddressId == addressId }
            .map { converter.toRestaurantResponseDtoFromEntity(it) }
            .toList()
    }

    fun getRestaurantById(id: String): RestaurantResponseDto {
        return converter.toRestaurantResponseDtoFromEntity(repository.findById(id).get())
    }

    fun calculateRestaurantRating(point: BigDecimal, id: String, countOfReview: BigDecimal) {
        val restaurant = repository.findById(id).get()
        val rating = restaurant.restaurantRating
        var count = countOfReview.toLong()

        if(count > 1) {
            count -= 1
            var totalPoint = count * rating!!.toLong()
            totalPoint += point.toLong()
            val newRating = totalPoint/(count+1)
            restaurant.restaurantRating = BigDecimal.valueOf(newRating)
        } else {
            restaurant.restaurantRating = point
        }

        repository.save(restaurant)
    }
}