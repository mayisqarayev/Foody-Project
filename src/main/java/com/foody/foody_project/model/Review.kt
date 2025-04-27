package com.foody.foody_project.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
data class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var reviewText: String?,
    var senderUserId: String?,
    var receiverId: String?,
    @Enumerated(EnumType.STRING)
    var receiverType: ReceiverType?,
    var reviewDate: LocalDate?,
    var reviewStatus: Boolean?,
    var reviewPoint: BigDecimal?
) {
    constructor(): this(
        null,null,null,null,
        null,null,null,null
    )
}
