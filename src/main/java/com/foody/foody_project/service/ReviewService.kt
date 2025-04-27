package com.foody.foody_project.service

import com.foody.foody_project.converter.ReviewConverter
import com.foody.foody_project.dto.request.PageRequestDto
import com.foody.foody_project.dto.request.SendReviewRequestDto
import com.foody.foody_project.dto.response.PageResponseDto
import com.foody.foody_project.exception.InvalidArgumentException
import com.foody.foody_project.repository.ReviewRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class ReviewService(
    private val repository: ReviewRepository,
    private val converter: ReviewConverter,
    private val foodService: FoodService
) {

    fun sendReviewToFood(requestDto: SendReviewRequestDto) {
        repository.save(converter.toEntityFromSendReviewRequestDto(requestDto))
        foodService.calculateFoodRating(
            requestDto.reviewPoint,
            requestDto.receiverId,
            repository.calculateFoodCount(requestDto.receiverId)
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
}