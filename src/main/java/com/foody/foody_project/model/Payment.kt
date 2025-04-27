package com.foody.foody_project.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDate

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
    val totalPay: BigDecimal?,
    var fkCartId: String?,
    var fkAddressId: String?
) {
    constructor(): this(
        null,null, null,null, null, null,null,null,null
    )
}
