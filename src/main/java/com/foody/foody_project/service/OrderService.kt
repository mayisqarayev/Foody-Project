package com.foody.foody_project.service

import com.foody.foody_project.converter.OrderConverter
import com.foody.foody_project.dto.request.AddOrderRequestDto
import com.foody.foody_project.dto.response.OrderResponseDto
import com.foody.foody_project.repository.OrderRepository
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class OrderService(
    private val repository: OrderRepository,
    private val converter: OrderConverter
) {
    fun getOrdersByUserId(userId: String): List<OrderResponseDto> {
        return repository.findAll().stream()
            .filter { it.fkUserId == userId }
            .filter { it.orderStatus == true }
            .map { converter.toOrderResponseDtoFromEntity(it) }
            .toList()
    }

    fun getOrderHistoryByUserId(userId: String): List<OrderResponseDto> {
        return repository.findAll().stream()
            .filter { it.fkUserId == userId }
            .map { converter.toOrderResponseDtoFromEntity(it) }
            .toList()
    }

    fun addOrder(requestDto: AddOrderRequestDto) {
        repository.save(converter.toEntityFromAddOrderRequestDto(requestDto))
    }

    fun completeOrder(id: String) {
        val order = repository.findById(id).get()
        order.orderStatus = false
        repository.save(order)
    }
}