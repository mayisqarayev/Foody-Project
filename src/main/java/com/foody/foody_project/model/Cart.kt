package com.foody.foody_project.model

import jakarta.persistence.*

@Entity
data class Cart(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var isPaid: Boolean? = false,
    @OneToMany(
        mappedBy = "fkCartId",
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL],
        targetEntity = CartItem::class
    )
    val cartItem: MutableList<CartItem> = mutableListOf()
) {
    constructor() : this(null, null, mutableListOf())
}
