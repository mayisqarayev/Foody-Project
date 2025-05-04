package com.foody.foody_project.service

import com.foody.foody_project.converter.PaymentConverter
import com.foody.foody_project.dto.response.PaymentResponseDto
import com.foody.foody_project.dto.request.AddPaymentRequestDto
import com.foody.foody_project.repository.PaymentRepository
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class PaymentService(
    private val repository: PaymentRepository,
    private val converter: PaymentConverter,
    private val cartService: CartService
) {
    fun addPayment(requestDto: AddPaymentRequestDto?) {
        repository.save(converter.toEntityFromAddPaymentRequestDto(requestDto))
        cartService.changeIsPaidById(requestDto?.cartId ?: "")
    }

    fun getPayments(): List<PaymentResponseDto> {
        val payments = repository.findAll()

        return payments.stream()
            .map { converter.toPaymentResponseDtoFromEntity(it) }
            .toList()
    }

    fun getPaymentDetails(id: String): PaymentResponseDto {
        return converter.toPaymentResponseDtoFromEntity(repository.findById(id).get())
    }
}