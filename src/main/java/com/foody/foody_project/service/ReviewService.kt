package com.foody.foody_project.service

import com.foody.foody_project.converter.ReviewConverter
import com.foody.foody_project.dto.request.PageRequestDto
import com.foody.foody_project.dto.request.SendReviewRequestDto
import com.foody.foody_project.dto.response.PageResponseDto
import com.foody.foody_project.exception.InvalidArgumentException
import com.foody.foody_project.repository.ReviewRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.math.BigDecimal
import kotlin.streams.toList

@Service
class ReviewService(
    private val repository: ReviewRepository,
    private val converter: ReviewConverter,
    private val foodService: FoodService,
    private val restaurantService: RestaurantService
) {

    fun sendReviewToFood(requestDto: SendReviewRequestDto) {
        repository.save(converter.toEntityFromSendReviewRequestDtoFood(requestDto))
        foodService.calculateFoodRating(
            requestDto.reviewPoint ?: BigDecimal.ZERO,
            requestDto.receiverId ?: "",
            repository.calculateCount(requestDto.receiverId)
        )
    }

    fun getReviewsByFoodId(foodId: String?, requestDto: PageRequestDto?): PageResponseDto {
        requestDto ?: InvalidArgumentException("Request is null")
        val reviewsPage = repository.findAll(PageRequest.of(
            requestDto?.pageNumber ?: 0,
            requestDto?.pageSize ?: 0
        ))

        val reviews = reviewsPage.content.stream()
            .filter { it.receiverId == foodId }
            .toList()

        return PageResponseDto(
            reviewsPage.totalPages,
            reviewsPage.totalElements,
            reviewsPage.isEmpty,
            reviews.stream()
                .map { converter.toReviewResponseDtoFromEntity(it) }
                .toList()
        )
    }

    fun sendReviewToRestaurant(requestDto: SendReviewRequestDto) {
        repository.save(converter.toEntityFromSendReviewRequestDtoRestaurant(requestDto))
        restaurantService.calculateRestaurantRating(
            requestDto.reviewPoint ?: BigDecimal.ZERO,
            requestDto.receiverId ?: "",
            repository.calculateCount(requestDto.receiverId)
        )
    }

    fun getReviewsByRestaurantId(restaurantId: String?, requestDto: PageRequestDto?): PageResponseDto {
        requestDto ?: InvalidArgumentException("Request is null")
        val reviewsPage = repository.findAll(PageRequest.of(
            requestDto?.pageNumber ?: 0,
            requestDto?.pageSize ?: 0
        ))

        val reviews = reviewsPage.content.stream()
            .filter { it.receiverId == restaurantId }
            .toList()

        return PageResponseDto(
            reviewsPage.totalPages,
            reviewsPage.totalElements,
            reviewsPage.isEmpty,
            reviews.stream()
                .map { converter.toReviewResponseDtoFromEntity(it) }
                .toList()
        )
    }
}