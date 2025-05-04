package com.foody.foody_project.model

import jakarta.persistence.*

@Entity
data class Favorites(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var userId: String?,
    @Enumerated(EnumType.STRING)
    var receiverType: ReceiverType?,
    var receiverId: String?,
    var status: Boolean?,
) {
    constructor(): this(null, null, null, null, null)
}
