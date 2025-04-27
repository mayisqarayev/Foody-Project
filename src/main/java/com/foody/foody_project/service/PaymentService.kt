package com.foody.foody_project.service

import com.foody.foody_project.converter.PaymentConverter
import com.foody.foody_project.dto.request.AddPaymentRequestDto
import com.foody.foody_project.repository.PaymentRepository
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val repository: PaymentRepository,
    private val converter: PaymentConverter
) {

    fun addPayment(requestDto: AddPaymentRequestDto) {

    }

}