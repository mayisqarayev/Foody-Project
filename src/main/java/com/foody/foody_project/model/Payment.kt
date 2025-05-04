package com.foody.foody_project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var paymentMethod: PaymentMethod?,
    var cardName: String?,
    var cardNumber: String?,
    var cardCvvCode: String?,
    var cardExpireDate: LocalDate?,
    var totalPay: BigDecimal?,
    var paymentDate: LocalDateTime?,
    var fkCartId: String?,
    var fkAddressId: String?
) {
    constructor(): this(
        null,null, null, null,null, null, null,null,null,null
    )
}
