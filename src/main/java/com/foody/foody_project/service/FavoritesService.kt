package com.foody.foody_project.service

import com.foody.foody_project.converter.FavoritesConverter
import com.foody.foody_project.dto.request.AddFavoritesRequestDto
import com.foody.foody_project.dto.response.FavoriteResponseDto
import com.foody.foody_project.dto.response.FavoritesResponseDto
import com.foody.foody_project.model.Favorites
import com.foody.foody_project.model.ReceiverType
import com.foody.foody_project.repository.FavoritesRepository
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class FavoritesService(
    private val repository: FavoritesRepository,
    private val converter: FavoritesConverter
) {

    fun addFoodToFavorites(requestDto: AddFavoritesRequestDto) {
        val favorite = Favorites()
        favorite.receiverType = ReceiverType.FOOD
        favorite.status = true
        favorite.receiverId = requestDto.receiverId
        favorite.userId = requestDto.userId
        repository.save(favorite)
    }

    fun addRestaurantToFavorites(requestDto: AddFavoritesRequestDto) {
        val favorite = Favorites()
        favorite.receiverType = ReceiverType.RESTAURANT
        favorite.status = true
        favorite.receiverId = requestDto.receiverId
        favorite.userId = requestDto.userId
        repository.save(favorite)
    }

    fun getFavoriteFoodsByUserId(userId: String): List<FavoritesResponseDto> {
        val favorites = repository.findAll()

        return favorites.stream()
            .filter { (it.userId == userId) && (it.status == true) }
            .map { converter.toFavoritesResponseDtoFromEntity(it) }
            .toList()
    }

    fun removeFoodFromFavorites(foodId: String) {
        repository.removeItemFromFavorites(foodId)
    }

    fun getFavoriteRestaurantsByUserId(userId: String): List<FavoriteResponseDto> {
        val favorites = repository.findAll()

        return favorites.stream()
            .filter { (it.userId == userId) && (it.status == true)}
            .map { converter.toFavoriteResponseDtoFromEntity(it) }
            .toList()
    }

    fun removeRestaurantFromFavorites(restaurantId: String) {
        repository.removeItemFromFavorites(restaurantId)
    }
}